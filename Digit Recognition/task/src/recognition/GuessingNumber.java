package recognition;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GuessingNumber {
    private final Scanner scanner = new Scanner(System.in);

    private int findIndexOfMax(double[] numbers) {
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                index = i;
            }
        }
        return index;
    }

    public void guessing() {
        Learning learning = new Learning();
        double[][] weights = new double[10][15];
        try {
            String filename = "/home/milkbeek/IdeaProjects/Digit Recognition/bias.txt";
            weights = (double[][]) SerializationUtils.deserialize(filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Input grid:");
        int[] number = new int[15];
        for (int i = 0; i < 5; i++) {
            char[] in = scanner.nextLine().toCharArray();
            number[i * 3] = 'X' == in[0] ? 1 : 0;
            number[i * 3 + 1] = 'X' == in[1] ? 1 : 0;
            number[i * 3 + 2] = 'X' == in[2] ? 1 : 0;
        }
        double[] outputNumber = new double[10];
        for (int i = 0; i < 10; i++) {
            double result = 0;
            for (int j = 0; j < 15; j++) {
                result += number[j] * weights[i][j];
            }
            outputNumber[i] = learning.calculateSigmoid(result);
        }
        System.out.println("This number is " + findIndexOfMax(outputNumber));
    }
}
