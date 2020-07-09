package recognition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Learning learning = new Learning();
        GuessingNumber guessingNumber = new GuessingNumber();
        System.out.println("1. Learn the network");
        System.out.println("2. Guess a number");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                learning.serialization();
                break;
            case 2:
                guessingNumber.guessing();
                break;
        }
    }
}
