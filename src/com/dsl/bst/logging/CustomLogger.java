/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved.
 */

package com.dsl.bst.logging;

import java.time.Duration;
import java.time.Instant;

public class CustomLogger
{
    private CustomLogger() {}

    public static void log(String message, Runnable runnable)
    {
        Instant start = Instant.now();
        runnable.run();
        Instant end = Instant.now();
        System.out.println(String.format("Time taken for %s: %d milliseconds" + "\n", message, Duration.between(start, end).toMillis()));
    }
}
