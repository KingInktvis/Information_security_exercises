package exercise2;

public class Mapping {
    private char[] alphabet =   {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] key =        {'u', 'o', 'i', 'e', 'a', 'z', 'y', 'x', 'w', 'v', 't', 's', 'r', 'q', 'p', 'n', 'm', 'l', 'k', 'j', 'h', 'g', 'f', 'd', 'c', 'b'};
    private int convert;

    public Mapping() {
        convert = 'A' - 'a';
    }

    public char encryptChar(char c) {
        int index = getAlphabetIndex(c);
        if (index == -1) return 0;
        return key[index];
    }

    public char decryptChar(char c) {
        boolean up = false;
        if (c >= 'A' && c <= 'Z') {
            up = true;
        }
        if (up) c -= convert;
        int index = getKeyIndex(c);
        if (index == -1) return 0;
        char ret = alphabet[index];
        if (up) ret += convert;

        return ret;
    }

    private int getAlphabetIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) return i;
        }
        return -1;
    }

    private int getKeyIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (key[i] == c) return i;
        }
        return -1;
    }

    public String decryptString(String text) {
        StringBuilder build = new StringBuilder(text);
        for (int i = 0; i < build.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char d = decryptChar(c);
                if (d != 0) build.setCharAt(i, d);
            }
        }
        return build.toString();
    }

    public String encryptString(String text) {
        StringBuilder build = new StringBuilder(text);
        for (int i = 0; i < build.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char d = encryptChar(c);
                if (d != 0) build.setCharAt(i, d);
            }
        }
        return build.toString();
    }
}
