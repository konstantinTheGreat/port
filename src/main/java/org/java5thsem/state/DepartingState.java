package org.java5thsem.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import static org.java5thsem.constant.PortConstant.SHIP_ARRIVED;

public class DepartingState extends ShipState {
    private static final Logger logger = LogManager.getLogger(DepartingState.class);

    public DepartingState(Ship ship) {
        super(ship);
    }

    @Override
    public void handle() {
        logger.info(SHIP_ARRIVED, ship.getId());
    }
}
