package org.java5thsem.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Dock;
import org.java5thsem.model.Port;
import org.java5thsem.model.Ship;

import static org.java5thsem.constant.PortConstant.SHIP_LOADING;

public class LoadingState extends ShipState {
    private static final Logger logger = LogManager.getLogger(LoadingState.class);
    private final Dock dock;

    public LoadingState(Ship ship, Dock dock) {
        super(ship);
        this.dock = dock;
    }

    @Override
    public void handle() {
        Port port = Port.getInstance(2, 100);
        if (port.getWarehouse().loadContainers(ship.getCargo())) {
            logger.info(SHIP_LOADING, ship.getId(), ship.getCargo());
            ship.setCargo(0);
        }
        dock.release();
        ship.setState(new DepartingState(ship));
    }
}
