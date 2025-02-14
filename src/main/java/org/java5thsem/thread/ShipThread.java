package org.java5thsem.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import java.util.concurrent.Callable;

import static org.java5thsem.constant.PortConstant.ERROR_PROCESSING;

public class ShipThread implements Callable<Boolean> {
    private static final Logger logger = LogManager.getLogger(ShipThread.class);
    private final Ship ship;

    public ShipThread(Ship ship) {
        this.ship = ship;
    }

    @Override
    public Boolean call() {
        try {
            return ship.call();
        } catch (Exception e) {
            logger.error(ERROR_PROCESSING, ship.getId(), e);
            return false;
        }
    }
}
