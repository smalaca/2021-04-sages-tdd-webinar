package com.smalaca.tdd.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    private final FizzBuzz fizzBuzz = new FizzBuzz();
    /*
Wymagania:
1. Gdy jest przekazana liczba (int) zwracamy tą liczbę w postaci String'a.
2. Gdy liczba jest podzielna przez 3 zwracamy Fizz.
3. Gdy liczba jest podzielna przez 5 zwracamy Buzz.
4. Gdy liczba jest podzielna przez 3 oraz 5 zwracamy FizzBuzz.
*/

    @Test
    void shouldReturn13AsString() {
        //given

        //when
        String actual = fizzBuzz.covert(13);

        //then
        assertThat(actual).isEqualTo("13");
    }

    @Test
    void shouldReturnNumberAsString() {
        //given

        //when
        String actual = fizzBuzz.covert(17);

        //then
        assertThat(actual).isEqualTo("17");
    }
}
