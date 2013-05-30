package com.jrodolfo.weather.util;

public class Timer {

    private final long start = System.currentTimeMillis();

    public static Timer start() {
	return new Timer();
    }

    public long stop() {
	return System.currentTimeMillis() - start;
    }
}
