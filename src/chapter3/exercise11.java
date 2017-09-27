package chapter3;

public class exercise11 {
    private int base = 43210;
    private int power = 23456;
    private int modulo = 99987;

    public exercise11() {
        StringBuilder powerBits = new StringBuilder(Integer.toBinaryString(power));
        System.out.println(powerModulo(powerBits) % modulo);
    }

    public long powerModulo(StringBuilder powerBits) {

        if (powerBits.length() == 0) {
            return 1;
        }
        char decision = powerBits.charAt(powerBits.length() - 1);
        powerBits.deleteCharAt(powerBits.length() - 1);
        long previous = powerModulo(powerBits);
        previous %= modulo;
        long ret = previous * previous;
        ret %= modulo;
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
