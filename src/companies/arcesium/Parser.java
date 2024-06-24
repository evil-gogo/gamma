package companies.arcesium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

enum CONSTANTS {
    CURLY_OPEN_BRACKETS('{'),
    CURLY_CLOSE_BRACKETS('}'),
    SQUARE_OPEN_BRACKETS('['),
    SQUARE_CLOSE_BRACKETS(']'),
    COLON(':'),
    COMMA(','),
    SPECIAL('|');

    private final char constant;

    CONSTANTS(char constant) {
        this.constant = constant;
    }

    @Override public String toString() {
        return String.valueOf(constant);
    }
}

class JSONObject {
    private final static char specialChar;
    private final static char commaChar;
    private HashMap<String, String> objects;

    static {
        specialChar = String.valueOf(CONSTANTS.SPECIAL).toCharArray()[0];
        commaChar = String.valueOf(CONSTANTS.COMMA).toCharArray()[0];
    }

    public JSONObject(String arg) {
        getJSONObjects(arg);
    }

    public void getJSONObjects(String arg) {
        objects = new HashMap<String, String>();

        if (arg.startsWith(String.valueOf(CONSTANTS.SQUARE_OPEN_BRACKETS)) && arg.endsWith(String.valueOf(CONSTANTS.SQUARE_CLOSE_BRACKETS))) {

            StringBuilder builder = new StringBuilder(arg);
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
            builder = replaceCOMMA(builder);

            for (String objects : builder.toString().split(String.valueOf(CONSTANTS.COMMA))) {

                String[] objectValue = objects.split(String.valueOf(CONSTANTS.COLON), 2);

                if (objectValue.length == 2) {
                    this.objects.put(objectValue[0].replace("'", "").replace("\"", ""),
                            objectValue[1].replace("'", "").replace("\"", ""));
                }
            }
        }
    }

    public StringBuilder replaceCOMMA(StringBuilder arg) {
        boolean isJsonArray = false;

        for (int i = 0; i < arg.length(); i++) {
            char ch = arg.charAt(i);

            if (isJsonArray) {
                if (String.valueOf(ch).compareTo(String.valueOf(CONSTANTS.COMMA)) == 0) {
                    arg.setCharAt(i, specialChar);
                }
            }

            if (String.valueOf(ch).compareTo(String.valueOf(CONSTANTS.SQUARE_OPEN_BRACKETS)) == 0) {
                isJsonArray = true;
            }
            if (String.valueOf(ch).compareTo(String.valueOf(CONSTANTS.SQUARE_CLOSE_BRACKETS)) == 0) {
                isJsonArray = false;
            }
        }

        return arg;
    }

    public String getValue(String key) {
        if (objects != null) {
            return objects.get(key).replace(specialChar, commaChar);
        }
        return null;
    }

    public JSONArray getJSONArray(String key) {
        if (objects != null) {
            return new JSONArray(objects.get(key).replace('|', ','));
        }
        return null;
    }
}

class JSONArray {
    private final static char specialChar;
    private final static char commaChar;

    private ArrayList<String> objects;

    static {
        specialChar = String.valueOf(CONSTANTS.SPECIAL).toCharArray()[0];
        commaChar = String.valueOf(CONSTANTS.COMMA).toCharArray()[0];
    }

    public JSONArray(String arg) {
        getJSONObjects(arg);
    }

    public void getJSONObjects(String arg) {
        objects = new ArrayList<String>();

        if (arg.startsWith(String.valueOf(CONSTANTS.SQUARE_OPEN_BRACKETS)) && arg.endsWith(String.valueOf(CONSTANTS.SQUARE_CLOSE_BRACKETS))) {

            StringBuilder builder = new StringBuilder(arg);

            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);

            builder = replaceCOMMA(builder);

            Collections.addAll(objects, builder.toString().split(String.valueOf(CONSTANTS.COMMA)));
        }
    }

    public StringBuilder replaceCOMMA(StringBuilder arg) {
        boolean isArray = false;

        for (int i = 0; i < arg.length(); i++) {
            char a = arg.charAt(i);
            if (isArray) {
                if (String.valueOf(a).compareTo(String.valueOf(CONSTANTS.COMMA)) == 0) {
                    arg.setCharAt(i, specialChar);
                }
            }

            if (String.valueOf(a).compareTo(String.valueOf(CONSTANTS.CURLY_OPEN_BRACKETS)) == 0) {
                isArray = true;
            }

            if (String.valueOf(a).compareTo(String.valueOf(CONSTANTS.CURLY_CLOSE_BRACKETS)) == 0) {
                isArray = false;
            }
        }

        return arg;
    }


    public String getObject(int index) {
        if (objects != null) {
            return objects.get(index).replace(specialChar, commaChar);
        }

        return null;
    }

    public JSONObject getJSONObject(int index) {
        if (objects != null) {
            return new JSONObject(objects.get(index).replace('|', ','));
        }

        return null;
    }
}



public class Parser {
    public static Map<String, Object> parseJson(String jsonString) {
        Map<String, Object> jsonMap = new HashMap<>();

        // Remove curly braces
        jsonString = jsonString.substring(1, jsonString.length() - 1);

        // Split by comma
        String[] keyValuePairs = jsonString.split(",");

        for (String pair : keyValuePairs) {
            // Split each pair by colon
            String[] entry = pair.split(":");

            // Trim extra spaces
            String key = entry[0].trim().replace("\"", ""); // Remove quotes
            String value = entry[1].trim().replace("\"", ""); // Remove quotes

            // Parse values as appropriate (here assuming all values are strings)
            jsonMap.put(key, value);
        }

        return jsonMap;
    }
    private final static String jsonString
            = "{'name':'user','id':1234,'marks':[{'english':85,'physics':80,'chemistry':75}]}";
    private final static String jsonString2 = "[{'groupName':'Group1','expressions':[{'name':'a','expressionType':'DIRECT','expression':'10','dependencies':[]},{'name':'b','expressionType':'RS_EXPRESSION','expression':'${a} + 10','dependencies':['a']},{'name':'c','expressionType':'DOLLAR_EXPRESSION','expression':'${a} + 10','dependencies':['a']}]}]";



    public static void main(String[] args) {
        //JSONObject user = new JSONObject(jsonString2);
        //System.out.println(user.toString());
        JSONObject marks = new JSONObject(jsonString2);
//        JSONObject subjects = marks.getJSONObject(0);
//
//        System.out.println(String.format("English marks - %s", subjects.getValue("english")));
//        System.out.println(String.format("Physics marks - %s", subjects.getValue("physics")));
//        System.out.println(String.format("Chemistry marks - %s", subjects.getValue("chemistry")));
        System.out.println("Hello");

        Map<String, Object> jsonMap = parseJson(jsonString2);

        // Print out the parsed JSON object
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}