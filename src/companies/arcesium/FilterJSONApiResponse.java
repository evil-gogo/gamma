package companies.arcesium;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

class Person {
    int id;
    String name;
    String username;
    String email;
    Address address;
    String website;
    Company company;

    @Override
    public String toString() {
        return "\n" + "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}' + "\n";
    }
}

class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}

class Geo {
    String lat;
    String lng;

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}

class Company {
    String name;
    String basename;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", basename='" + basename + '\'' +
                '}';
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    INDEX_TYPE type;
    List<Integer> personIndexList;

    TrieNode() {
        children = new TrieNode[257];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie(List<Person> listPerson) {
        root = new TrieNode();
    }

    public void insert(String word, int personIndex, INDEX_TYPE type) {
        TrieNode temp = root;
        for (int i = 0; word != null && i < word.length(); i++) {

            int index = word.charAt(i);
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
        if (temp.personIndexList == null) {
            temp.personIndexList = new ArrayList<>();
        }
        temp.personIndexList.add(personIndex);
        temp.type = type;
    }

    public List<Integer> search(String word, INDEX_TYPE type) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);
            if (temp.children[index] == null) {
                return null;
            }
            temp = temp.children[index];
        }
        if (temp != null && temp.isEndOfWord && temp.type == type) {

            return temp.personIndexList;
        }
        return null;
    }
}

enum INDEX_TYPE {
    ID,
    NAME,
    USERNAME,
    EMAIL,
    WEBSITE,
    ADDRESS_STREET,
    ADDRESS_SUITE,
    ADDRESS_CITY,
    ADDRESS_ZIPCODE,
    COMPANY_NAME,
    COMPANY_BASENAME
}


class Result {
    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        String api = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(api);
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Exception while reading the content " + e.getMessage());
        }

        Type collectionType = new TypeToken<List<Person>>() {
        }.getType();
        List<Person> listPerson = new Gson().fromJson(content.toString(), collectionType);
        //System.out.println(listPerson);

        Trie personTrie = new Trie(listPerson);
        for (int i = 0; i < listPerson.size(); i++) {
            Person person = listPerson.get(i);

            personTrie.insert(person.id + "", i, INDEX_TYPE.ID);
            personTrie.insert(person.name, i, INDEX_TYPE.NAME);
            personTrie.insert(person.username, i, INDEX_TYPE.USERNAME);
            personTrie.insert(person.email, i, INDEX_TYPE.EMAIL);
            personTrie.insert(person.email, i, INDEX_TYPE.WEBSITE);
            personTrie.insert(person.address.street, i, INDEX_TYPE.ADDRESS_STREET);
            personTrie.insert(person.address.suite, i, INDEX_TYPE.ADDRESS_SUITE);
            personTrie.insert(person.address.city, i, INDEX_TYPE.ADDRESS_CITY);
            personTrie.insert(person.address.zipcode, i, INDEX_TYPE.ADDRESS_ZIPCODE);
            personTrie.insert(person.company.name, i, INDEX_TYPE.COMPANY_NAME);
            personTrie.insert(person.company.basename, i, INDEX_TYPE.COMPANY_BASENAME);
        }


        String searchField = inputList.get(0);
        String operationType = inputList.get(1);
        String inputValue = inputList.get(2);

        INDEX_TYPE searchType = null;
        switch (searchField) {
            case "id":
                searchType = INDEX_TYPE.ID;
                break;
            case "name":
                searchType = INDEX_TYPE.NAME;
                break;
            case "username":
                searchType = INDEX_TYPE.USERNAME;
                break;
            case "email":
                searchType = INDEX_TYPE.EMAIL;
                break;
            case "website":
                searchType = INDEX_TYPE.WEBSITE;
                break;
            case "address.street":
                searchType = INDEX_TYPE.ADDRESS_STREET;
                break;
            case "address.suite":
                searchType = INDEX_TYPE.ADDRESS_SUITE;
                break;
            case "address.city":
                searchType = INDEX_TYPE.ADDRESS_CITY;
                break;
            case "address.zipcode":
                searchType = INDEX_TYPE.ADDRESS_ZIPCODE;
                break;
            case "company.name":
                searchType = INDEX_TYPE.COMPANY_NAME;
                break;
            case "company.basename":
                searchType = INDEX_TYPE.COMPANY_BASENAME;
                break;
        }
        System.out.println(inputList);
        List<Integer> result = null;
        switch (operationType) {
            case "EQUALS":
                result = personTrie.search(inputValue, searchType);

                break;
            case "IN":
                List<Integer> finalINResultList = new ArrayList<>();
                String[] split = inputValue.split(",");
                for (int i = 0; i < split.length; i++) {
                    result = personTrie.search(split[i], searchType);
                    finalINResultList.addAll(result);
                    System.out.println(result);
                }

                result = finalINResultList;
                break;
        }
        if (result == null) {
            result = new ArrayList<>();
            result.add(-1);
            return result;
        }
        List<Integer> personIdList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            personIdList.add(listPerson.get(result.get(i)).id);
        }
        return personIdList;
    }

    public static void main(String[] args) {
        //String[] input = {"username", "EQUALS", "Garimag" };
        //String[] input ={"username", "EQUALS", "tom"};
        String[] input = {"address.city", "IN", "Mumbai,Kolkata" };

        int size = 3;
        System.out.println(apiResponseParser(List.of(input), size));
    }
}
