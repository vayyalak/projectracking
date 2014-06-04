package com.gridpoint.energy.util.concurrent;

import java.util.concurrent.Callable;

public final class TaskUtils {

    private TaskUtils() {
        // NOT TO BE INSTANTIATED
    }

    /**
     * Wraps the {@link Runnable} with code to set the name of the executing thread and return it to its previous name
     * at completion or exception.
     * 
     * Better than a {@link Runnable} renaming its own Thread as it is easy to forget to clean up. The Thread might then
     * get reused in a ThreadPool and having the old name around would lead to confusion.
     */
    public static Runnable namedThreadFor(final String prefix, final Runnable toBeNamed) {
        return new Runnable() {

            @Override
            public void run() {
                String originalName = Thread.currentThread().getName();
                Thread.currentThread().setName(prefix + " " + originalName);
                try {
                    toBeNamed.run();
                } finally {
                    Thread.currentThread().setName(originalName);
                }
            }

        };
    }

    /**
     * Wraps the {@link Callable} with code to set the name of the executing thread and return it to its previous name
     * at completion or exception.
     * 
     * Better than a {@link Callable} renaming its own Thread as it is easy to forget to clean up. The Thread might then
     * get reused in a ThreadPool and having the old name around would lead to confusion.
     */
    public static <T> Callable<T> namedThreadFor(final String prefix, final Callable<T> toBeNamed) {
        return new Callable<T>() {

            @Override
            public T call() throws Exception {
                String originalName = Thread.currentThread().getName();
                Thread.currentThread().setName(prefix + " " + originalName);

                try {
                    T result = toBeNamed.call();
                    return result;

                } finally {
                    Thread.currentThread().setName(originalName);
                }
            }
        };
    }
}
