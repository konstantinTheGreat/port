package org.java5thsem.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java5thsem.model.Ship;
import org.java5thsem.thread.TaskExecutor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.java5thsem.constant.PortConstant.*;

public class ShipProcessor {
    private static final Logger logger = LogManager.getLogger(ShipProcessor.class);
    private final TaskExecutor taskExecutor;

    public ShipProcessor() {
        this.taskExecutor = new TaskExecutor();
    }

    public void processShips(List<Ship> ships) {
        List<Future<Boolean>> futures = taskExecutor.submitTasks(ships);

        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    logger.info(FINISHED_WORK, future.get());
                } else {
                    logger.warn(FAILURE, future.get());
                }
            } catch (ExecutionException | InterruptedException e) {
                logger.error(ERROR_PROCESSING, e.getMessage(), e);
            }
        }

        taskExecutor.shutdown();
    }
}
