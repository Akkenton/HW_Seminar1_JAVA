package Tasks.taskex;
/*
 * Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.  

Ввод: 2? + ?5 = 69  
Вывод: 24 + 45 = 69
 */

// Комментарий: сделал восстановление для уравнений, где результат за знаком равно известен (т.е. без знаков вопроса) и для чисел в периоде 0..99
// Сложные конструкции if else. Попробовал оставить комментарии - но мне кажется это сильный перегруз.
// Был бы благодарен за помощь - в каком направлении копать, чтобы сделать много проще.

import java.util.Scanner;

public class t4ex {
    public static void main(String[] args) {
        System.out.println("\033[H\033[J");

        Scanner stroke = new Scanner(System.in, "Cp866");
        System.out.println("Введите уравнение(например: 2? + ?5 = 69): ");
        String urav = stroke.nextLine();
        stroke.close();

        // -------------------------------------------
        String uravResult = urav.replaceAll(" ", ""); // убираем пробелы

        char[] chars = uravResult.toCharArray();
        String firstCount = "";
        String resultCount = "";
        String secondCount = "";

        int i = 0;
        while (chars[i] != '+') {
            firstCount = firstCount + chars[i];
            i++;
        }

        boolean flag = false;
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == '=') {
                flag = true;
                continue;
            }
            if (flag == false)
                continue;
            else {
                resultCount = resultCount + chars[i];
            }
        }

        secondCount = uravResult.replace(resultCount, "");
        secondCount = secondCount.replace("+", "");
        secondCount = secondCount.replace("=", "");
        secondCount = secondCount.replace(firstCount, "");

        // --------------------------------------------------
        char[] fCount = firstCount.toCharArray();
        char[] sCount = secondCount.toCharArray();
        int resultNum = Integer.parseInt(resultCount);
        // --------------------------------------------------

        int qFIndex = 0;
        int firstNum = 0;
        int checkF = 0;
        firstCount = new String();
        for (i = 0; i < fCount.length; i++) {
            if (fCount[i] == '?') {
                qFIndex = i;
                checkF++;
            }
            firstCount = firstCount + fCount[i];
        }
        if (checkF == 2) {
            firstNum = 0;
        } else {
            firstCount = firstCount.replace("?", "");
            if (firstCount.isEmpty() == true)
                firstNum = 0;
            else
                firstNum = Integer.parseInt(firstCount);
        }

        // --------------------------------------------------------
        int secondNum = 0;
        int qSIndex = 0;
        secondCount = new String();
        int checkS = 0;
        for (i = 0; i < sCount.length; i++) {
            if (sCount[i] == '?') {
                checkS++;
                qSIndex = i;
            }
            secondCount = secondCount + sCount[i];
        }
        if (checkS == 2) {
            secondNum = 0;
        } else {
            secondCount = secondCount.replace("?", "");
            if (secondCount.isEmpty() == true)
                secondNum = 0;
            else
                secondNum = Integer.parseInt(secondCount);
        }

        // -----------------------------------------------

        int resNum1 = resultNum / 10;
        int resNum2 = resultNum % 10;

        // -----------------------------------------------
        if (checkF == 0 && checkS == 0) {
            if (firstNum + secondNum == resultNum) {
                System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
            } else
                System.out.println("Уравнение не имеет решения1!");
        } else {

            if ((checkF == 0 && checkS == 1) || (checkS == 0 && checkF == 1)) {
                if (secondNum == 0) {
                    secondNum = resultNum - firstNum;
                    System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);

                } else {
                    if (checkF == 0 && checkS == 1) {
                        if (qSIndex != 0 & (resNum1 - (firstNum / 10) == secondNum)) {
                            secondNum = resultNum - firstNum;
                            System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
                        } else {
                            if (qSIndex != 0)
                                System.out.println("Уравнение не имеет решения2!");
                        }
                        if (qSIndex == 0 && (resNum2 - (firstNum / 10) == secondNum)) {
                            secondNum = resultNum - firstNum;
                            System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
                        } else {
                            if (qSIndex == 0)
                                System.out.println("Уравнение не имеет решения3!");
                        }
                    }
                }

                if (checkS == 0 && checkF == 1) {
                    if (firstNum == 0) {
                        firstNum = resultNum - secondNum;
                        System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
                    } else {
                        if ((qFIndex != 0 && (resNum1 - (secondNum / 10) == firstNum))) {
                            firstNum = resultNum - secondNum;
                            System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
                        } else {
                            System.out.println("Уравнение не имеет решения4!");
                        }
                        if ((qFIndex == 0 && (resNum2 - (secondNum / 10) == firstNum))) {
                            firstNum = resultNum - secondNum;
                            System.out.printf("%d + %d = %d \n", firstNum, secondNum, resultNum);
                        } else {
                            System.out.println("Уравнение не имеет решения5!");
                        }
                    }
                }
            } else {

                // -----------------------------------------------------

                if ((checkF == 2) && (checkS == 0)) {
                    firstNum = resultNum - secondNum;
                } else {
                    if ((qFIndex == 0) && (qSIndex != 0)) {
                        firstNum = ((resNum1 - secondNum) * 10) + firstNum;
                        System.out.println(firstNum);
                    }
                    if ((qFIndex == 1) && (qSIndex != 1)) {
                        firstNum = firstNum * 10 + (resNum2 - secondNum);
                        System.out.println(firstNum);
                    }
                    if ((qFIndex == 1) && (qSIndex != 1)) {
                        firstNum = firstNum * 10 + (resNum2 - secondNum);
                        System.out.println(firstNum);
                    }
                    if ((qFIndex == 0) && (qSIndex == 0)) {
                        if (((firstNum + secondNum) % 10 != resNum2) && (firstNum + secondNum != resNum2)) {
                            System.out.println((firstNum + secondNum) % 10);
                            System.out.println("Уравнение не имеет решения6!");
                        } else {
                            firstNum = (resNum1 / 2) * 10 + firstNum;
                            secondNum = resultNum - firstNum;
                            System.out.println(firstNum);
                            System.out.println(secondNum);
                        }
                    }
                    if ((qFIndex == 1) && (qSIndex == 1)) {
                        if (((firstNum + secondNum) % 10 != resNum2) && (firstNum + secondNum != resNum2)) {
                            System.out.println((firstNum + secondNum) % 10);
                            System.out.println("Уравнение не имеет решения7!");
                        } else {
                            firstNum = resNum2 / 2 + firstNum * 10;
                            secondNum = resultNum - firstNum;
                            System.out.println(secondNum);
                        }
                    }
                }

                // ------------------------------------------------

                if ((checkS == 2) && (checkF == 0)) {
                    secondNum = resultNum - firstNum;
                } else {
                    if ((qSIndex == 0) && (qFIndex != 0)) {
                        secondNum = ((resNum1 - firstNum) * 10) + secondNum;
                        System.out.println(secondNum);
                    }
                    if ((qSIndex == 1) && (qFIndex != 1)) {
                        secondNum = secondNum * 10 + (resNum2 - firstNum);
                        System.out.println(secondNum);
                    }
                    if ((qSIndex == 1) && (qFIndex != 1)) {
                        secondNum = secondNum * 10 + (resNum2 - firstNum);
                        System.out.println(secondNum);
                    }
                }
            }
        }
    }
}
