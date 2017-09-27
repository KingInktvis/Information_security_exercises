package chapter3;

public class exercise11 {
    private int base = 43210;
    private int power = 23456;
    private int modulo = 99987;

    public exercise11() {
        StringBuilder powerBits = new StringBuilder(Integer.toBinaryString(power));
        System.out.println(powerModulo(powerBits));
    }

    public int powerModulo(StringBuilder powerBits) {

        if (powerBits.length() == 0) {
            return 1;
        }
        char decision = powerBits.charAt(powerBits.length() - 1);
        powerBits.deleteCharAt(powerBits.length() - 1);
        int previous = powerModulo(powerBits);
        int ret = (previous * previous) % modulo;
        if (decision == '1') {
            ret *= base;
            ret %= modulo;
        }
        return ret;
    }

    public static void main(String[] args) {
        new exercise11();
    }
}
