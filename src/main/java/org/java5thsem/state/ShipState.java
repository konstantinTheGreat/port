package org.java5thsem.state;


import org.java5thsem.model.Ship;

public abstract class ShipState {
    protected final Ship ship;

    protected ShipState(Ship ship) {
        this.ship = ship;
    }

    public abstract void handle();
}
