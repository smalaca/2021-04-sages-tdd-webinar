package com.smalaca.tdd.fizzbuzz;

public class FizzBuzz {
    String covert(int number) {
        String value = "";

        if (isDividableBy(number, 3)) {
            value += "Fizz";
        }

        if (isDividableBy(number, 5)) {
            value += "Buzz";
        }

        return value.isEmpty() ? String.valueOf(number) : value;
    }

    private boolean isDividableBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
