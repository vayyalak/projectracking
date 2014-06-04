package com.gridpoint.energy.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class ExecutorServices {
    private static final Logger logger = Logger.getLogger(ExecutorServices.class);

    /**
     * Shuts down an ExecutorService as described here:
     * 
     * @see http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ExecutorService.html
     */
    public static void shutdownAndAwaitTermination(String poolName, ExecutorService pool, int taskCompletionTimeoutSecs, int taskTerminationTimeoutSecs) {
        logger.info(poolName + " Calling shutdown to stop accepting new tasks");
        pool.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(taskCompletionTimeoutSecs, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(taskTerminationTimeoutSecs, TimeUnit.SECONDS)) {
                    logger.error(poolName + " Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
