package com.gridpoint.energy.util.time;

public class SystemCurrentTimeProvider implements CurrentTimeProvider {

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

}
