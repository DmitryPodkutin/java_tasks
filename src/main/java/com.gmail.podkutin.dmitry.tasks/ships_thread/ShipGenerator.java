package com.gmail.podkutin.dmitry.tasks.ships_thread;


import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Ship;
import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Size;
import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Type;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private final Random random = new Random();
    private int count;
    private final Tunnel tunnel;

    public ShipGenerator(int count, Tunnel tunnel) {
        this.count = count;
        this.tunnel = tunnel;
    }

    private Type typeGenerate() {
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size sizeGenerate() {
        return Size.values()[random.nextInt(Size.values().length)];
    }

    @Override
    public void run() {
        while (count > 0) {
            tunnel.add(new Ship(typeGenerate(), sizeGenerate()));
            count--;
        }
    }
}
