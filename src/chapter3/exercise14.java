package chapter3;

public class exercise14 {
    private int a = 10;
    int b = -21;
    int p = 41;
    int[] p1 = {3,6};

    public exercise14() {
        int multi = 15;
        int[] start = {2,7};
        int[] result = start;
        for (int i = 0; i < 15; i++) {
            result = pointAddition(result, start);
        }
        System.out.println("x = " + result[0]);
        System.out.println("y = " + result[1]);
    }

    public int[] pointAddition(int[] point1, int[] point2) {
        int m;
        if (point1[0] == point2[0] && point1[1] == point2[1]) {
            //m=(3X1^2 + a) * (2y1) ^ -1 mod p
            m = (3 * (point1[0] * point1[0]) + a) + (1 / (2 * point1[1])) % p;
        }else {
            //(y2 - y1) * (x2 - x1) ^ -1 mod p
            m = (point2[1] - point1[0]) * (1 / (point2[0] - point1[0])) % p;
        }

        int[] nPoint = new int[2];
        //x3 = m^2 - x1 - x2 mod p
        nPoint[0] = (m * m - point1[0] - point2[0]) % p;

        //y3 = m(x1 - x3) -y1 mod p
        nPoint[1] = (m * (point1[0] - nPoint[0]) - point1[1]) % p;
        return  nPoint;
    }

    public static void main(String[] args) {
        new exercise14();
    }
}
