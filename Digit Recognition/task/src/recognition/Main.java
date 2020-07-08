package recognition;

import java.util.Scanner;

public class Main {
    public static int findIndexOfMax(int[] numbers) {
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bias = {-1, 6, 1, 0, 2, 0, -1, 3, -2, -1};
        int[][] weights = {
                {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1},//0
                {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1},//1
                {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1},//2
                {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//3
                {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1},//4
                {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//5
                {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//6
                {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1},//7
                {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//8
                {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//9
        };
        System.out.println("Input grid:");
        int[] number = new int[15];
        for (int i = 0; i < 5; i++) {
            char[] in = scanner.nextLine().toCharArray();
            number[i * 3] = 'X' == in[0] ? 1 : 0;
            number[i * 3 + 1] = 'X' == in[1] ? 1 : 0;
            number[i * 3 + 2] = 'X' == in[2] ? 1 : 0;
        }
        int[] outputNumber = new int[10];
        for (int i = 0; i < 10; i++) {
            int result = bias[i];
            for (int j = 0; j < 15; j++) {
                result += number[j] * weights[i][j];
            }
            outputNumber[i] = result;
        }
        //System.out.println(Arrays.toString(outputNumber));
        System.out.println("This number is " + findIndexOfMax(outputNumber));
    }
}
