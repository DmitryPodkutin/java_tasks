package com.gmail.podkutin.dmitry.tasks.ships_thread.model;

public enum Size {
    SMALL(10),
    MEDIUM(100),
    LARGE(150);

    Size(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        return value;
    }
}
