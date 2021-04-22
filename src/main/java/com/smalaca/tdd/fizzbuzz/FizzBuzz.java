package com.smalaca.tdd.fizzbuzz;

public class FizzBuzz {
    String covert(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
