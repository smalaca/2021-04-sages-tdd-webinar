package com.smalaca.tdd.testsuite;

public interface TestScenarioRepository {
    boolean existsWithName(String name);

    void save(TestScenario testScenario, Author author);
}
