package org.java5thsem.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Dock;
import org.java5thsem.model.Port;
import org.java5thsem.model.Ship;

import static org.java5thsem.constant.PortConstant.SHIP_DEPARTED;

public class DockingState extends ShipState {
    private static final Logger logger = LogManager.getLogger(DockingState.class);

    public DockingState(Ship ship) {
        super(ship);
    }

    @Override
    public void handle() {
        Port port = Port.getInstance(2, 100);
        Dock dock = port.getAvailableDock();
        if (dock != null) {
            logger.info(SHIP_DEPARTED, ship.getId(), dock.getId());
            ship.setState(new LoadingState(ship, dock));
        }
    }
}
