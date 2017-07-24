package gcd;

/**
 * Created by cheng on 7/6/2017.
 */
public class GreatestCommonDivider {
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        if (x%y == 0) return y;
        return gcd(y, x%y);
    }

    public static void main(String[] args) {
        System.out.println(gcd(5, 10));
        System.out.println((10)%(-6));
    }
}
