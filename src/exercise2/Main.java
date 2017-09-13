package exercise2;

public class Main {

    public static void main(String[] args) {
        ArgsInterpreter input = new ArgsInterpreter(args);


        FileIO tool = new FileIO();

        StringBuilder original = tool.readFile("res/2017.enc");

        if (!input.isSet("-o")){
            toLower(original);
        }

        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c >= 'a' && c <= 'z'){
                char d = decrypt(c, 1);
                original.setCharAt(i, d);
            }

        }

        tool.writeFile("res/out.txt", original);

        System.out.print(original);
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

    public static char encrypt(char c, int key) {
        c += key;
        if (c > 'z') c -= 'z' - 'a';
        return c;
    }

    public static char decrypt(char c, int key) {
        c -= key;
        if (c < 'a') c += 'z' - 'a';
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
