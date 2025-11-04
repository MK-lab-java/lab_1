/*
 * Copyright (c) 2025. Коломієць Максим Дмитрович
 *
 * Рішення до Лабораторної роботи №1
 * згідно з наданими інструкціями.
 */
package ad241.kolomiets;

/**
 * Головний клас для Лабораторної роботи №1.
 * Містить реалізацію трьох завдань та метод main для їх тестування.
 *
 * @author Коломієць Максим
 * @version 1.0
 */
public class Main {

    /**
     * Цей метод є "точкою входу" програми.
     * Ми використовуємо його для тестування методів,
     * написаних для виконання завдань лабораторної роботи.
     */
    public static void main(String[] args) {

        // --- Тестування Завдання 1 ---
        System.out.print("--- Завдання 1: isIncreasing ---\n");
        // Оголошення масивів для тестування
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 1, 2, 2, 2};
        int[] array3 = {1, 2, 1, 5};

        // Використовуємо System.out.print() для виведення, як у прикладі
        System.out.print("Масив {1, 2, 3, 4, 5} зростаючий? " + isIncreasing(array1) + "\n");
        System.out.print("Масив {1, 1, 2, 2, 2} зростаючий? " + isIncreasing(array2) + "\n");
        System.out.print("Масив {1, 2, 1, 5} зростаючий? " + isIncreasing(array3) + "\n");

        System.out.print("\n--- Завдання 2: FizzBuzz ---\n");
        fizzBuzz(); // Цей метод сам виводить результат на екран

        System.out.print("\n--- Завдання 3: canBalance ---\n");
        // Використовуємо приклади з документа
        int[] balance1 = {1, 1, 1, 2, 1}; // true
        int[] balance2 = {2, 1, 1, 2, 1}; // false
        int[] balance3 = {10, 10};        // true

        System.out.print("Масив {1, 1, 1, 2, 1} можна збалансувати? " + canBalance(balance1) + "\n");
        System.out.print("Масив {2, 1, 1, 2, 1} можна збалансувати? " + canBalance(balance2) + "\n");
        System.out.print("Масив {10, 10} можна збалансувати? " + canBalance(balance3) + "\n");
    }

    /**
     * 1. Метод перевіряє, чи кожен елемент масиву (довжиною 2+)
     * більше або дорівнює попередньому.
     *
     * @param array Масив цілих чисел для перевірки.
     * @return true, якщо масив не спадає, і false в іншому випадку.
     */
    public static boolean isIncreasing(int[] array) {
        // Використовуємо цикл for, як у прикладі
        // Починаємо з індексу 1, щоб порівнювати з попереднім (i-1)
        for (int i = 1; i < array.length; i++) {
            // Використовуємо оператор if, як у прикладі
            if (array[i] < array[i - 1]) {
                return false; // Знайшли елемент, який менший за попередній
            }
        }
        // Якщо цикл завершився, значить, всі елементи не спадали
        return true;
    }

    /**
     * 2. Метод реалізує гру FizzBuzz.
     * Виводить на екран числа від 1 до 100, замінюючи:
     * - Числа, кратні 3, на "Fizz"
     * - Числа, кратні 5, на "Buzz"
     * - Числа, кратні 3 і 5, на "FizzBuzz"
     */
    public static void fizzBuzz() {
        // Використовуємо цикл for для ітерації від 1 до 100
        for (int i = 1; i <= 100; i++) {

            // Перевірка на кратність 15 (3 і 5) має бути першою!
            if (i % 15 == 0) {
                System.out.print("FizzBuzz");
            } else if (i % 3 == 0) { // Кратні 3
                System.out.print("Fizz");
            } else if (i % 5 == 0) { // Кратні 5
                System.out.print("Buzz");
            } else {
                System.out.print(i); // Виводимо саме число
            }

            // Додаємо символ нового рядка, як у прикладі
            System.out.print("\n");
        }
    }

    /**
     * 3*. Метод перевіряє, чи можна розділити масив (довжиною 2+)
     * на дві частини з рівною сумою.
     *
     * @param array Масив цілих чисел для перевірки.
     * @return true, якщо такий розподіл можливий, і false інакше.
     */
    public static boolean canBalance(int[] array) {
        // Крок 1: Обчислюємо загальну суму всіх елементів
        int totalSum = 0;
        // Використовуємо цикл "foreach" (enhanced for), як у прикладі
        for (int value : array) {
            totalSum += value;
        }

        // Крок 2: Ітеруємо по масиву, накопичуючи суму лівої частини
        int leftSum = 0;
        // Цикл іде до (length - 1), щоб права частина завжди мала хоча б один елемент
        for (int i = 0; i < array.length - 1; i++) {
            leftSum += array[i]; // Додаємо поточний елемент до лівої суми

            // Обчислюємо праву суму
            int rightSum = totalSum - leftSum;

            // Перевіряємо, чи рівні суми
            if (leftSum == rightSum) {
                return true; // Знайшли точку балансу!
            }
        }

        // Якщо пройшли весь цикл і не знайшли балансу
        return false; //
    }
}