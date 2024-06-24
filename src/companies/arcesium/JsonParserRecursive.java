package companies.arcesium;

import java.util.*;

class Group {
    String groupName;
    List<Expression> expressions;
}

class Expression {
    String name;
    String expressionType;
    String expression;
    String dependencies;
}
public class JsonParserRecursive {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\",\"children\":[{\"name\":\"Jane\",\"age\":10},{\"name\":\"Doe\",\"age\":5}],\"address\":{\"street\":\"123 Main St\",\"city\":\"Anytown\"}}";
         String jsonString2 = "[{'groupName':'Group1','expressions':[{'name':'a','expressionType':'DIRECT','expression':'10','dependencies':[]},{'name':'b','expressionType':'RS_EXPRESSION','expression':'${a} + 10','dependencies':['a']},{'name':'c','expressionType':'DOLLAR_EXPRESSION','expression':'${a} + 10','dependencies':['a']}]},{'groupName':'Group2','expressions':[{'name':'a','expressionType':'DIRECT','expression':'20','dependencies':[]},{'name':'b','expressionType':'RS_EXPRESSION','expression':'${a} + 10','dependencies':['a']}]},{'groupName':'Group3','expressions':[]}]";




        List<Object> jsonMap = parseJsonArray(jsonString2);

        // Print out the parsed JSON object
        System.out.println(jsonMap);
        for (int i = 0; i < jsonMap.size(); i++) {
            System.out.println(i + "  " + jsonMap.get(i));
        }


    }

    public static Map<String, Object> parseJson(String jsonString) {
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        // Remove outer curly braces if present
        if (jsonString.startsWith("{") && jsonString.endsWith("}")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
        }

        String[] keyValuePairs = jsonString.split(",");
        for (String pair : keyValuePairs) {
            // Split each pair by the first colon to handle nested objects
            int colonIndex = pair.indexOf(":");
            String key = pair.substring(0, colonIndex).trim().replace("\"", "");
            String valueString = pair.substring(colonIndex + 1).trim();

            Object value;
            if (valueString.startsWith("{") && valueString.endsWith("}")) {
                // Recursively parse nested object
                value = parseJson(valueString);
            } else if (valueString.startsWith("[") && valueString.endsWith("]")) {
                // Handle array
                value = parseJsonArray(valueString);
            } else {
                // Handle simple value (string, number, boolean)
                value = parseValue(valueString);
            }

            jsonMap.put(key, value);
        }

        return jsonMap;
    }

    public static List<Object> parseJsonArray(String arrayString) {
        List<Object> jsonArray = new ArrayList<>();

        // Remove outer brackets if present
        if (arrayString.startsWith("[") && arrayString.endsWith("]")) {
            arrayString = arrayString.substring(1, arrayString.length() - 1);
        }

        String[] elements = arrayString.split(",");
        for (String element : elements) {
            element = element.trim();
            if (element.startsWith("{") && element.endsWith("}")) {
                // Recursively parse nested object in array
                jsonArray.add(parseJson(element));
            } else if (element.startsWith("[") && element.endsWith("]")) {
                // Recursively handle nested arrays (not supported in this basic example)
                jsonArray.add(parseJsonArray(element));
            } else {
                // Handle simple value (string, number, boolean)
                jsonArray.add(parseValue(element));
            }
        }

        return jsonArray;
    }

    public static Object parseValue(String valueString) {
        if (valueString.startsWith("\"") && valueString.endsWith("\"")) {
            // String value
            return valueString.substring(1, valueString.length() - 1);
        } else if ("true".equals(valueString)) {
            // Boolean true
            return true;
        } else if ("false".equals(valueString)) {
            // Boolean false
            return false;
        } else {
            // Number value (parse as integer for simplicity)
            try {
                return Integer.parseInt(valueString);
            } catch (NumberFormatException e) {
                // Handle non-integer numbers as strings or further parsing based on requirements
                return valueString;
            }
        }
    }

    public static void printJson(Map<String, Object> jsonMap, int indentLevel) {
        String indent = "  ".repeat(indentLevel);
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            System.out.print(indent + entry.getKey() + ": ");
            Object value = entry.getValue();
            if (value instanceof Map) {
                System.out.println();
                printJson((Map<String, Object>) value, indentLevel + 1);
            } else if (value instanceof List) {
                System.out.println();
                printJsonArray((List<Object>) value, indentLevel + 1);
            } else {
                System.out.println(value);
            }
        }
    }

    public static void printJsonArray(List<Object> jsonArray, int indentLevel) {
        String indent = "  ".repeat(indentLevel);
        for (Object element : jsonArray) {
            if (element instanceof Map) {
                printJson((Map<String, Object>) element, indentLevel + 1);
            } else if (element instanceof List) {
                printJsonArray((List<Object>) element, indentLevel + 1);
            } else {
                System.out.println(indent + element);
            }
        }
    }
}
