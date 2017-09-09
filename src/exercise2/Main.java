package exercise2;

public class Main {

    public static void main(String[] args) {
        boolean o = false;
        boolean d = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o": o = true;
                    break;
                case "-d": d = true;
                    break;
            }
        }
        FileIO tool = new FileIO();

        System.out.print(tool.readFile("res/2017.enc"));

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
