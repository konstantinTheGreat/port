package org.java5thsem.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.java5thsem.constant.PortConstant.SHIP_LOADED;

public class FileReaderUtil {
    private static final Logger logger = LogManager.getLogger(FileReaderUtil.class);

    public static List<Ship> loadShips(String filePath) {
        List<Ship> ships = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    int capacity = Integer.parseInt(parts[1]);
                    int cargo = Integer.parseInt(parts[2]);
                    ships.add(new Ship(id, capacity, cargo));
                }
            }
        } catch (IOException e) {
            logger.error(SHIP_LOADED, filePath, e);
        }
        return ships;
    }
}
