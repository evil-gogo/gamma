package companies.docusign.evaluate_json_gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String schema = "{"
                + "  \"_type\": \"Person\","
                + "  \"properties\": ["
                + "    {\"name\": \"name\", \"type\": \"string\", \"required\": true},"
                + "    {\"name\": \"age\", \"type\": \"number\"},"
                + "    {\"name\": \"address\", \"type\": \"string\"}"
                + "  ]"
                + "}";

        System.out.println(validateJson(schema, input));
    }

    private static boolean validateJson(String schemaStr, String dataStr) {
        JsonObject schema = JsonParser.parseString(schemaStr).getAsJsonObject();
        JsonObject data = JsonParser.parseString(dataStr).getAsJsonObject();

        if (!data.has("_type") || !data.get("_type").getAsString().equals(schema.get("_type").getAsString())) {
            return false;
        }

        JsonArray schemaProperties = schema.getAsJsonArray("properties");

        for (JsonElement property : schemaProperties) {
            JsonObject schemaProperty = property.getAsJsonObject();
            String field_name = schemaProperty.get("name").getAsString();
            String field_type = schemaProperty.get("type").getAsString();
            boolean field_required = schemaProperty.has("required") && schemaProperty.get("required").getAsBoolean();

            if (field_required && !data.has(field_name)) {
                return false;
            }

            if (data.has(field_name)) {
                JsonElement value = data.get(field_name);
                if (!isTypeValid(value, field_type)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isTypeValid(JsonElement value, String type) {
        switch (type) {
            case "string":
                return value.isJsonPrimitive() && value.getAsJsonPrimitive().isString();
            case "number":
                return value.isJsonPrimitive() && value.getAsJsonPrimitive().isNumber();
            case "boolean":
                return value.isJsonPrimitive() && value.getAsJsonPrimitive().isBoolean();
        }
        return false;
    }
}