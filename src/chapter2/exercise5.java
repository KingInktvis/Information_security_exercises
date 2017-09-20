package chapter2;

import java.util.ArrayList;

public class exercise5 {
    public static void main(String[] args) {
        String og = "informationsecurity";
        String key = "vlaksjdhfgqodzmxncb";
        String altKey = "tlftrffwmixor|{xbch";
        StringBuilder en = xorString(og, key);
        StringBuilder de = xorString(en.toString(), altKey);
        System.out.print(de);
    }

    public static StringBuilder xorString(String text, String key) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            char b = key.charAt(i);
            char t = (char) (a ^ b);
            res.append(t);
        }
        return res;
    }

}