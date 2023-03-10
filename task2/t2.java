package Tasks.task2;

/**
 * Вывести все простые числа от 1 до 1000
 */

// Решение такое: внешним циклом проверяем все числа от 1 до 1000. Внутренним
// циклом проверяем на то, делится ли
// число внешнего цикла без остатка на число внутреннего цикла(кроме 1 и на само
// себя, исключая цифру 2). Если делится,
// то цикл прерывается и переходим к другому число. Если число прошло проверку
// условием и флаг поднят - то выводим в консоль.

public class t2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        boolean flag = true; // Флаг для определения простого числа
        for (int i = 2; i <= 1000; i++) { // внешний цикл для проверки от 1 до 1000
            for (int j = 1; j < 10; j++) { // внутренний цикла для проверки на простое число от 1 до 9

                if ((i % j == 0) && (i != 2) && (j != 1) && (j != i)) { // условие на "не простое число"
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.printf(" %d", i);
            } else
                flag = true; // возвращаем исходное значение флагу для проверки следующего числа
        }
    }
}
