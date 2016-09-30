import java.util.Scanner;

/**
 * BinHexCheck will ask you for a binary value and hexidecimal value then tell
 * you if they are equivalent.
 *
 * @author Zack Zatkin-Gold
 */
public class BinHexCheck {
    private static boolean compareBinToHex(String binary, String hex) {
        int n1 = convertFromBase(binary, 2);
        int n2 = convertFromBase(hex, 16);
        if (n1 < 0 || n2 < 0) {
            return false;
        }
        return n1 == n2;
    }

    private static int convertFromBase(String number, int base) {
        if (base < 2 || (base > 10 && base != 16)) return -1;
        int value = 0;
        for(int i = number.length() - 1; i >= 0; i -= 1) {
            int digit = Character.digit(number.charAt(i), base);
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Compare a binary value to a hexdecimal value");
        System.out.print("Enter the binary value: ");
        String binary = scanner.nextLine();
        System.out.print("Enter the hex value: ");
        String hex = scanner.nextLine();
        boolean sameValues = compareBinToHex(binary, hex);
        System.out.print("The two values provided are ");
        if(!sameValues) {
            System.out.print("not ");
        }
        System.out.println("the same.");
    }
}
