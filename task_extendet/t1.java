package Tasks.task_extendet;
/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
 */

// Комментарий: так как int на 4 байта, ограничимся значением n до 31 (максимально возможный для 4 байт)

public class t1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");   // очистка консоли
        int n = 5;                             
        int count = 0;                         // Переменная суммы чисел
        int countF = 1;                        // Переменная факториала
        for (int i = 1; i <= n; i++) {
            count = count + i;
            countF = countF * i;
        }
        System.out.printf("Сумма чисел: %d \n", count);
        System.out.printf("Факториал: %d", countF);
    }  
}