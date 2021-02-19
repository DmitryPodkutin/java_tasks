package com.gmail.podkutin.dmitry.tasks.ships_thread;

import com.gmail.podkutin.dmitry.tasks.ships_thread.model.Type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel(5);
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new ShipGenerator(10, tunnel), "ShipGenerator"));
        threads.add(new Thread(new SeaPort(tunnel, Type.MET), "Meat port "));
        threads.add(new Thread(new SeaPort(tunnel, Type.CORN), "Corn port "));
        threads.add(new Thread(new SeaPort(tunnel, Type.WATER), "Water port "));
        threads.forEach(Thread::start);
    }
}

