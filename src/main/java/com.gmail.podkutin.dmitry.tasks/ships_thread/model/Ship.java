package com.gmail.podkutin.dmitry.tasks.ships_thread.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ship {
    private final Type type;
    private final Size size;
    private int units;

    public Ship(Type type, Size size) {
        this.type = type;
        this.size = size;
    }

    public boolean checkUnits() {
        return units < size.getValue();
    }

    public void loadUnitsOnToShip(int units) {
        this.units += units;
    }
}
