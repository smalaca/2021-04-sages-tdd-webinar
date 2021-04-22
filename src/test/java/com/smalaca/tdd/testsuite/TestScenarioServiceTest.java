package com.smalaca.tdd.testsuite;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

public class TestScenarioServiceTest {
    private static final String TEST_SCENARIO_NAME = "some great name of test scenario";

    /*
            Wymagania:
            1. TestScenarioService umożliwia zapisanie TestScenario dla danego Autora gdy TestScenario jest poprawny.
            2. TestScenario jest poprawny gdy zawiera co najmniej jedną asercję oraz fragment wywołujący kod produkcyjny.
            3. TestScenario może zostać zapisany gdy nie istnieje TestScenario z taką samą nazwą
             */
    private final TestScenarioRepository repository = mock(TestScenarioRepository.class);
    private final TestScenarioService service = new TestScenarioService(repository);

    @Test
    void shouldSaveValidTestScenario() {
        //given
        givenNotExistingTestScenarioWithName(TEST_SCENARIO_NAME);
        Author author = new Author();
        TestScenario testScenario = new TestScenario(TEST_SCENARIO_NAME);
        testScenario.add(new TestAssertion());
        testScenario.add(new GivenPart());

        //when
        service.add(testScenario, author);

        //then
        thenTestScenarioWasSaved(testScenario, author);
    }

    @Test
    void shouldNotSaveTestScenarioWithoutAssertion() {
        //given
        givenNotExistingTestScenarioWithName(TEST_SCENARIO_NAME);
        Author author = new Author();
        TestScenario testScenario = new TestScenario(TEST_SCENARIO_NAME);
        testScenario.add(new GivenPart());

        //when
        service.add(testScenario, author);

        //then
        thenTestScenarioWasNotSaved();
    }

    @Test
    void shouldNotSaveTestScenarioWithoutExecutablePart() {
        //given
        givenNotExistingTestScenarioWithName(TEST_SCENARIO_NAME);
        Author author = new Author();
        TestScenario testScenario = new TestScenario(TEST_SCENARIO_NAME);
        testScenario.add(new TestAssertion());

        //when
        service.add(testScenario, author);

        //then
        thenTestScenarioWasNotSaved();
    }

    @Test
    void shouldNotSaveValidTestScenarioWhenTestScenarioWithGivenNameExists() {
        //given
        givenExistingTestScenarioWithName(TEST_SCENARIO_NAME);
        Author author = new Author();
        TestScenario testScenario = new TestScenario(TEST_SCENARIO_NAME);
        testScenario.add(new TestAssertion());
        testScenario.add(new GivenPart());

        //when
        service.add(testScenario, author);

        //then
        thenTestScenarioWasNotSaved();
    }

    private void givenExistingTestScenarioWithName(String name) {
        given(repository.existsWithName(name)).willReturn(true);
    }

    private void givenNotExistingTestScenarioWithName(String name) {
        given(repository.existsWithName(name)).willReturn(false);
    }

    private void thenTestScenarioWasSaved(TestScenario testScenario, Author author) {
        then(repository).should().save(testScenario, author);
    }

    private void thenTestScenarioWasNotSaved() {
        then(repository).should(never()).save(any(), any());
    }
}
