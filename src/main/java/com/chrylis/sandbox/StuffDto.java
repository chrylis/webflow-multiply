package com.chrylis.sandbox;

public class StuffDto {

    private final int value;

    private final String greeting;

    public StuffDto(int value, String greeting) {
        this.value = value;
        this.greeting = greeting;
    }

    public int getValue() {
        return value;
    }

    public String getGreeting() {
        return greeting;
    }
}
