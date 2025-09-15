package ru;

public class Main {
    public static void main(String[] args) {
        // Создать несколько экземпляров дробей: где f1 это одна треть, f2 две пятых, а f3 это семь восьмых
        Fraction f1 = new Fraction(1, 3); // 1/3
        Fraction f2 = new Fraction(2, 5); // 2/5
        Fraction f3 = new Fraction(7, 8); // 7/8

        // Посчитать f1.sum(f2).sum(f3).minus(5)
        Fraction result = f1.sum(f2).sum(f3).minus(5);

        // Результат
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f1.sum(f2).sum(f3).minus(5) = " + result);
    }
}