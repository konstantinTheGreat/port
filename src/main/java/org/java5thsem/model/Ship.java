package org.java5thsem.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.state.DepartingState;
import org.java5thsem.state.DockingState;
import org.java5thsem.state.ShipState;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Ship implements Callable<Boolean> {
    private static final Logger logger = LogManager.getLogger(Ship.class);
    private final int id;
    private final int capacity;
    private int cargo;
    private ShipState state;

    public Ship(int id, int capacity, int cargo) {
        this.id = id;
        this.capacity = capacity;
        this.cargo = cargo;
        this.state = new DockingState(this);
    }

    @Override
    public Boolean call() {
        while (!(state instanceof DepartingState)) {
            state.handle();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return true;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
