package com.gmail.podkutin.dmitry.tasks.ships_thread;

import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Ship;
import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Type;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private final List<Ship> tunnel = new ArrayList<>(5);
    private final int maxShipsOnTunnel;

    public Tunnel(int maxShipsOnTunnel) {
        this.maxShipsOnTunnel = maxShipsOnTunnel;
    }


    synchronized public void add(Ship ship) {
        while (tunnel.size() == maxShipsOnTunnel) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tunnel.add(ship);
        notifyAll();
    }

    synchronized public Ship get(Type type) {
        while (tunnel.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (tunnel.get(0).getType().equals(type)) {
            System.out.println(Thread.currentThread().getName() + " port picks up the ship from the tunnel: ");
            notifyAll();
            return tunnel.remove(0);
        }
        return null;
    }
}
