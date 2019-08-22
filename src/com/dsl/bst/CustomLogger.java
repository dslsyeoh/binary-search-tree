/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst;

import java.time.Duration;
import java.time.Instant;

public class CustomLogger
{
    private CustomLogger() {}

    static void log(String message, Runnable runnable)
    {
        Instant start = Instant.now();
        runnable.run();
        Instant end = Instant.now();
        System.out.println(String.format("Time taken for %s: %d milliseconds" + "\n", message, Duration.between(start, end).toMillis()));
    }
}
