package companies.arcesium.p_evaluate_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

class Result {
    public static List<String> evaluate(String api) {
        List<String> list = new LinkedList<>();

        StringBuilder jsonString = new StringBuilder();
        try {
            URL url = new URL(api);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line).append("\n");
            }
            bufferedReader.close();

            System.out.println(jsonString);
        } catch (Exception e) {
            System.out.println("Exception while reading the content " + e.getMessage());
        }
        System.out.println(jsonString);

        try {
            JSONArray jsonArray = new JSONArray(jsonString.toString());
            if (validateJSON(jsonArray)) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON is invalid.");
            }
        } catch (JSONException e) {
            System.out.println("Invalid JSON format.");
        }

        return list;
    }

    public static boolean validateJSON(JSONArray jsonArray) {
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (!validateGroup(jsonObject)) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean validateGroup(JSONObject groupObject) throws JSONException {
        if (!groupObject.has("groupName") || !(groupObject.get("groupName") instanceof String)) {
            return false;
        }

        if (!groupObject.has("expressions") || !(groupObject.get("expressions") instanceof JSONArray)) {
            return false;
        }
        JSONArray expressions = groupObject.getJSONArray("expressions");
        for (int i = 0; i < expressions.length(); i++) {
            if (!validateExpression(expressions.getJSONObject(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateExpression(JSONObject expression) throws JSONException {
        if (!expression.has("name") || !(expression.get("name") instanceof String)) {
            return false;
        }
        if (!expression.has("expressionType") || !(expression.get("expressionType") instanceof String)) {
            return false;
        }
        if (!expression.has("expression") || !(expression.get("expression") instanceof String)) {
            return false;
        }
        if (!expression.has("dependencies") || !(expression.get("dependencies") instanceof JSONArray)) {
            return false;
        }
        JSONArray dependencies = expression.getJSONArray("dependencies");
        for (int i = 0; i < dependencies.length(); i++) {
            if (!(dependencies.get(i) instanceof String)) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public static void main(String[] args) {
        String api = "https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/test1";
        List<String> result = Result.evaluate(api);
        System.out.println(result);
    }
}