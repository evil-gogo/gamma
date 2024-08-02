package companies.nasdaq.stringutils_concat;

class StringUtils {
    public static String concat(String[] strings) {
        StringBuilder sb = new StringBuilder();


        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = { "f", "o", "o", "bar" };
        System.out.println(concat(strings));
    }

}
