package recognition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] weights = new int[]{
                2, 1, 2, 4, -4, 4, 2, -1, 2};
        System.out.println("Input grid:");
        String[] number = new String[9];
        int k = 0;
        while (k != 9) {
            String[] numbers = scanner.nextLine().split("");
            for (String s : numbers) {
                number[k] = s;
                ++k;
            }
        }
        int result = -5;
        for (int i = 0; i < 9; i++) {
            if (number[i].equals("X")) {
                result += weights[i];
            }
        }
        if (result > 0) {
            System.out.println("This number is 0");
        } else {
            System.out.println("This number is 1");
        }
    }
}
