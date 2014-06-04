package com.gridpoint.energy.domainmodel;

public class PredictedUsageInfo {
    private final double usage;
    private final double r2;
    private final double a;
    private final double b;
    private final double c;
    private final int hdd;
    private final int cdd;

    public PredictedUsageInfo(double usage, double r2, double a, double b, double c, int hdd, int cdd) {
        this.usage = usage;
        this.r2 = r2;
        this.a = a;
        this.b = b;
        this.c = c;
        this.hdd = hdd;
        this.cdd = cdd;
    }

    public double getUsage() {
        return usage;
    }

    public double getR2() {
        return r2;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int getHdd() {
        return hdd;
    }

    public int getCdd() {
        return cdd;
    }
}
