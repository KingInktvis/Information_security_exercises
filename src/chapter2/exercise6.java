package chapter2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class exercise6 {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String text = "Feistel";
        md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();
        String hexStr = bytesToHex(digest);
        md.update(digest);
        byte[] digest2 = md.digest();
        System.out.println(hexStr);
        System.out.println(bytesToHex(digest2));
    }

    //https://stackoverflow.com/a/9855338
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
