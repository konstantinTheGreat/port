package org.java5thsem.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import org.java5thsem.service.ShipProcessor;
import org.java5thsem.util.FileReaderUtil;
import java.util.List;

import static org.java5thsem.constant.PortConstant.FILE_PATH;
import static org.java5thsem.constant.PortConstant.START;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info(START);

        List<Ship> ships = FileReaderUtil.loadShips(FILE_PATH);

        ShipProcessor shipProcessor = new ShipProcessor();

        shipProcessor.processShips(ships);
    }
}
