package companies.docusign.evaluate_json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;
// {
//   "_type":"Person",
//   "properties":[
//     {
//       "name":"name",
//       "type":"string",
//       "required":true
//     },
//     {
//       "name":"age",
//       "type":"number"
//     },
//     {
//       "name":"address",
//       "type":"string"
//     }
//   ]
// }
// {"_type": "Person", "name": "Gagan" }} // Success
// {"_type": "Person", "name": 123 }}  // Should fail
// {"_type": "Person", age: 10 }}  // Should fail
// {"_type": "Person", "name" : "gaga", age: 10 }}  // Should fail

public class Solution {
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
        JSONObject schema = new JSONObject(schemaStr);
        JSONObject data = new JSONObject(dataStr);

        if (!data.has("_type") || !data.getString("_type").equals(schema.getString("_type"))) {
            return false;
        }

        JSONArray schemaProperties = schema.getJSONArray("properties");

        for (int i = 0; i < schemaProperties.length(); i++) {
            JSONObject schemaProperty = schemaProperties.getJSONObject(i);
            String field_name = schemaProperty.getString("name");
            String field_type = schemaProperty.getString("type");
            boolean field_required = schemaProperty.optBoolean("required", false);

            if (field_required && !data.has(field_name)) {
                return false;
            }

            if (data.has(field_name)) {
                Object value = data.get(field_name);
                if (!isTypeValid(value, field_type)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isTypeValid(Object value, String type) {
        switch (type) {
            case "string":
                return value instanceof String;
            case "number":
                return value instanceof Integer;
            case "boolean":
                return value instanceof Boolean;
        }
        return false;
    }
}
