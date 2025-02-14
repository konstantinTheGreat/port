package org.java5thsem.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.java5thsem.constant.PortConstant.*;

public class TaskExecutor {
    private static final Logger logger = LogManager.getLogger(TaskExecutor.class);
    private final ExecutorService executorService;

    public TaskExecutor() {
        this.executorService = Executors.newFixedThreadPool(TEN); // Shared thread pool
    }

    public List<Future<Boolean>> submitTasks(List<Ship> ships) {
        logger.info(SUBMITTING_SHIPS, ships.size());

        return ships.stream()
                .map(ship -> executorService.submit(new ShipThread(ship))) // Submit tasks to the shared thread pool
                .toList();
    }

    public void shutdown() {
        logger.info(SHUTTING_DOWN);
        executorService.shutdown();
    }
}
