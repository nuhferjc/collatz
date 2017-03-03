import java.util.Scanner;

/*
 * Author: Joseph Nuhfer
 *
 * Given a range of integers a to b inclusive, where a <= b and a, b >= 1, this program calculates the integer with the largest Collatz length.
 */

public class Collatz {
    private static int[] resultTable;

    private static int collatzLength(long x) {
        if (x < 100000000) {    
            if (resultTable[(int) x] != 0) {
                return resultTable[(int) x];
            }
            if (x % 2 == 0) {
                resultTable[(int) x] = collatzLength(x / 2) + 1;
                return resultTable[(int) x];
            }
            resultTable[(int) x] = collatzLength(3 * x + 1) + 1;
            return resultTable[(int) x];
        }
        else {
            if (x % 2 == 0) {
                return collatzLength(x / 2) + 1;
            }
            return collatzLength(3 * x + 1) + 1;
        }
    }

    public static void main(String[] args) {
        resultTable = new int[100000000];
        resultTable[1] = 1;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the range: ");
        long a = keyboard.nextInt();
        long b = keyboard.nextInt();
        long maxCollatzLength = 0;
        long maxInRange = 0;
        if (a > b) {
            System.out.println("Invalid input");
            return;
        }
        for (long i = a; i <= b; i++) {
            if (collatzLength(i) > maxCollatzLength) {
                maxCollatzLength = collatzLength(i);
                maxInRange = i;
            }
        }
        System.out.println("The number with the maximum Collatz length in the range: " + maxInRange);
        System.out.println("Its Collatz length: " + maxCollatzLength);  
    }
}
