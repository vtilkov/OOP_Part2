package ru;

public class Summ {

    public static double sumAll(Number... numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}