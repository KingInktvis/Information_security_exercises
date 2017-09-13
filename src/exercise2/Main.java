package exercise2;

public class Main {

    public static void main(String[] args) {
        String result = "";
        String loc;
        ArgsInterpreter input = new ArgsInterpreter(args);
        if (input.getValue("-i") != null) {
            loc = input.getValue("-i");
        }else {
            return;
        }

        FileIO tool = new FileIO();

        StringBuilder original = tool.readFile(loc);

        if (!input.isSet("-o")){
            toLower(original);
        }

        if (input.getValue("-shift") != null){
            int shift = Integer.parseInt(input.getValue("-shift"));
            if (input.isSet("-d")){
                result = decryptString(original.toString(), shift);
            }else {
                result = encryptString(original.toString(), shift);
            }
        }else if (input.getValue("-map") != null) {
            Mapping map = new Mapping(input.getValue("-map"));
            if (input.isSet("-d")) {
                result = map.decryptString(original.toString());
            }else {
                result = map.encryptString(original.toString());
            }
        }else {
            printUsageInformation();
        }

        System.out.print(result);
    }

    public static void toLower(StringBuilder text) {
        int diff = 'A' - 'a';
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c -= diff;
                text.setCharAt(i, c);
            }
        }
    }

    public static char encryptChar(char c, int key) {
        c += key;
        if ((c > 'z' && c < 'A') || c > 'Z') c -= 'z' - 'a' + 1;
        return c;
    }

    public static String decryptString(String text, int key) {
        StringBuilder build = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char d = decryptChar(c, key);
                build.setCharAt(i, d);
            }
        }
        return text;
    }

    public static String encryptString(String text, int key) {
        StringBuilder build = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char d = encryptChar(c, key);
                build.setCharAt(i, d);
            }
        }
        return text;
    }

    public static char decryptChar(char c, int key) {
        boolean up = false;

        c -= key;
        if (c < 'a' || c > 'z') c += 'z' - 'a' + 1;
        return c;
    }

    public static void printUsageInformation() {
        System.out.println(
                "Usage: substitution [-o] [-d] mapping\n" +
                        "Where:\n" +
                        "   -o: keep non-letters as is, honor letter casing\n" +
                        "   -d: decrypt\n" +
                        "   mapping: 26 letter char-mapping\n" +
                        "            or an int-value\n" +
                        "\n" +
                        "En/Decrypts stdin to stdout. Only letters are encrypted,\n" +
                        "all other characters are silently ignored, unless -o was\n" +
                        "specified, in which case they are used as-is.\n" +
                        "When -o is specified, letter casing is honored, otherwise all\n" +
                        "letters are converted to lower-case letters.\n" +
                        "Use an int-value to do a letter shift (% 26, 0: a = a)\n" +
                        "Shift 3 is the classical Caesar encryption"
        );
    }
}
