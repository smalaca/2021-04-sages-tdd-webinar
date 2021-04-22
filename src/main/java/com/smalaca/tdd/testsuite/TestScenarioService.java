package com.smalaca.tdd.testsuite;

public class TestScenarioService {
    private final TestScenarioRepository repository;

    public TestScenarioService(TestScenarioRepository repository) {
        this.repository = repository;
    }

    void add(TestScenario testScenario, Author author) {
        if (testScenario.isValid() && !repository.existsWithName(testScenario.name())) {
            repository.save(testScenario, author);
        }
    }
}
