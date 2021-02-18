package com.gmail.podkutin.dmitry.tasks.ships_thread;

import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Ship;
import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Type;

public class SeaPort implements Runnable {
    private final Tunnel tunnel;
    private final Type type;

    public SeaPort(Tunnel tunnel, Type type) {
        this.tunnel = tunnel;
        this.type = type;
    }

    private void loadingOnAShip() {
        Ship ship = tunnel.get(type);
        if (ship != null) {
            while (ship.checkUnits()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ship.loadUnitsOnToShip(10);
            }
            System.out.println(Thread.currentThread().getName() +" " + " loaded the ship. " + ship.getUnits() + " units of " + ship.getType());
        }
    }

    @Override
    public void run() {
        while (true) {
            loadingOnAShip();
        }
    }
}
