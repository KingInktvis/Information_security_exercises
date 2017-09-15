package exercise2;

public class Vigenere {
    private String key;
    private char[][] matrix;
    private int[] shifts;
    private Shifting shifter;

    public Vigenere(String key) {
        shifter = new Shifting();
        this.key = key;
        shifts = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            shifts[i] = key.charAt(i) - 'a';
        }
    }

    public String encrypt(String text) {
        StringBuilder build = new StringBuilder(text);
        int pointer = 0;
        for (int i = 0; i < build.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                build.setCharAt(i, shifter.encryptChar(c, shifts[pointer]));
                pointer = (pointer + 1) % shifts.length;
            }
        }
        return build.toString();
    }

    public String decrypt(String text) {
        StringBuilder build = new StringBuilder(text);
        int pointer = 0;
        for (int i = 0; i < build.length(); i++) {
            char c = build.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                build.setCharAt(i, shifter.decryptChar(c, shifts[pointer]));
                pointer = (pointer + 1) % shifts.length;
            }
        }
        return build.toString();
    }

    public static void main(String[] args) {
        Vigenere v = new Vigenere("abc");
        System.out.print(v.decrypt(v.encrypt("hello")));
    }
}
