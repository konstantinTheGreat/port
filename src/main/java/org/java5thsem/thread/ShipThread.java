package org.java5thsem.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import java.util.concurrent.Callable;


public class ShipThread implements Callable<Boolean> {
    private static final Logger logger = LogManager.getLogger(ShipThread.class);
    private final Ship ship;

    public ShipThread(Ship ship) {
        this.ship = ship;
    }

    @Override
    public Boolean call() {
        return ship.call();
    }
}
