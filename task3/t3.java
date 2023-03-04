package Tasks.task3;
/*
 * Реализовать простой калькулятор (+ - / *)
 */

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        System.out.println("\033[H\033[J");

        Scanner num = new Scanner(System.in, "Cp866");
        System.out.println("Введите первое число: ");
        int count1 = num.nextInt();
        System.out.println("Введите операцию(*,+,/,-): ");
        var znak = num.next();                                  
        System.out.println("Введите второе число: ");
        int count2 = num.nextInt();
        num.close();

        int result;
        System.out.printf("%d %s %d = ", count1, znak, count2);

        switch (znak) {
            case "*":
                result = count1 * count2;
                System.out.print(result);
                break;
            case "/":
                result = count1 / count2;
                System.out.print(result);
                break;
            case "+":
                result = count1 + count2;
                System.out.print(result);
                break;
            case "-":
                result = count1 - count2;
                System.out.print(result);
                break;

            default:
                System.out.println("Не верное выражение знака!");
                break;
        }
    }
}
