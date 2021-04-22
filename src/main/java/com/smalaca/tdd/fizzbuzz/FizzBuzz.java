package com.smalaca.tdd.fizzbuzz;

public class FizzBuzz {
    String covert(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
