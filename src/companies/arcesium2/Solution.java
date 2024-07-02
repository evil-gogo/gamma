package companies.arcesium2;

import java.io.*;
import java.util.*;
import java.net.*;

class Result {
    public static List<String> evaluate(String api) {
        List<String> list = new LinkedList<>();

        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(api);
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();

            System.out.println(content);
        } catch (Exception e) {
            System.out.println("Exception while reading the content " + e.getMessage());
        }

        return list;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        String api = "https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/test1";
        List<String> result = Result.evaluate(api);
        System.out.println(result);
    }
}

