package com.smalaca.tdd.testsuite;

public class TestScenario {
    private final String name;
    private TestAssertion assertion;
    private GivenPart given;

    public TestScenario(String name) {
        this.name = name;
    }

    void add(TestAssertion assertion) {
        this.assertion = assertion;
    }

    void add(GivenPart given) {
        this.given = given;
    }

    boolean hasAssertions() {
        return assertion != null;
    }

    boolean hasExecutablePart() {
        return given != null;
    }
}
