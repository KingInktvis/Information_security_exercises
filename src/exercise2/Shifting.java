package exercise2;

public class Shifting {
    public char encryptChar(char c, int key) {
        c += key;
        if ((c > 'z' && c < 'A') || c > 'Z') c -= 'z' - 'a' + 1;
        return c;
    }

    public String decryptString(String text, int key) {
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

    public String encryptString(String text, int key) {
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

    public char decryptChar(char c, int key) {
        boolean up = false;

        c -= key;
        if (c < 'a' || c > 'z') c += 'z' - 'a' + 1;
        return c;
    }
}
