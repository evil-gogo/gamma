package companies.docusign.evaluate_expression_json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

class Result {
    public static List<String> evaluate(String jsonString) {
        List<String> list = new LinkedList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
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
        String input = "[{\"groupName\":\"Group1\",\"expressions\":[{\"name\":\"a\",\"expressionType\":\"DIRECT\",\"expression\":\"10\",\"dependencies\":[]},{\"name\":\"b\",\"expressionType\":\"RS_EXPRESSION\",\"expression\":\"${a} + 10\",\"dependencies\":[\"a\"]},{\"name\":\"c\",\"expressionType\":\"DOLLAR_EXPRESSION\",\"expression\":\"${a} + 10\",\"dependencies\":[\"a\"]}]}]";
        List<String> result = Result.evaluate(input);
        System.out.println(result);
    }
}