package ru;

public final class Fraction extends Number {

    private final int numerator; // final (неизменяемость)
    private final int denominator; // final (неизменяемость)

    /*Для числителя задать отрицательное значение можно, в этом случае вся дробь считается отрицательной
    Для знаменателя отрицательное значение недопустимо*/
    public Fraction(int numerator, int denominator) {

        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю"); // проверка знаменателя
        if (denominator < 0) { // упрощаем дробь, а также если дробь отрицательная, перемещение знака минуса в числитель
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Для знаменателя отрицательное значение недопустимо
    public Fraction(int number) {
        this.numerator = number;
        this.denominator = 1;
    }

    // Объекты дробей не могут изменять свое состояние
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /*Может выполнять операции сложения, вычитания с другой Дробью или целым числом. Результатом операции должна быть новая Дробь*/
    private static int gcd(int a, int b) {
        // Базовый случай рекурсии: если b равно 0, то a является НОД.
        if (b == 0) {
            return a;
        }
        // Рекурсивный вызов: заменяем большее число на меньшее, а меньшее на остаток от деления.
        return gcd(b, a % b);
    }

    // Метод для сокращения дроби
    public Fraction reduce() {
        int gcd = gcd(numerator, denominator);
        // Делим числитель и знаменатель на НОД
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    // Сложение с другой дробью (+)
    public Fraction sum(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;

        Fraction result = new Fraction(newNumerator, commonDenominator);
        return result.reduce(); // Возвращаем сокращенную дробь
    }

    // Перегрузка метода sum для сложения с целым числом (+)
    public Fraction sum(int number) {
        return this.sum(new Fraction(number));
    }

    // Вычитание другой дроби (+)
    public Fraction minus(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;

        Fraction result = new Fraction(newNumerator, commonDenominator);
        return result.reduce();
    }


    // Перегрузка метода minus для вычитания целого числа
    public Fraction minus(int number) {
        return this.minus(new Fraction(number));
    }

    //Может вернуть строковое представление вида “числитель/знаменатель” (toString)
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    //Задача Практика ООП. Полиморфизм #5. Дробь это число
    // Переопределение метода intValue()
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    // Переопределение метода longValue()
    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    // Переопределение метода floatValue()
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    // Переопределение метода doubleValue()
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}