package com.gridpoint.energy.util.stats;

import org.apache.log4j.Logger;

/**
 * A useful collection of finance functions.
 *
 * User: brentedwards
 * Date: 6/18/13
 * <p/>
 * Copyright (c) 2013, GridPoint. All rights reserved.
 */
public class Finance {
    private static Logger logger = Logger.getLogger(Finance.class);

    /* The net present value of a time series of cash flows.
       This method assumes that all cash flows are a uniform time apart.

       See: http://www.investopedia.com/terms/n/npv.asp
       (Note: I have swapped the sign of cashFlows[0] from Investopedia's definition.
       In Investopedia, cashFlows[0] has the opposite sign from the rest of the cash flows.)
     */
    public double NPV(double rate, double[] cashFlows) {
        double NPV = 0.0;
        double rateDiscount = 1.0;

        for (int i = 0; i < cashFlows.length; i++) {
            // WEIRD: Microsoft assumes that the first value of its NPV is period 1, not period 0.
            NPV += cashFlows[i] / Math.pow(1 + rate, i + 1);
        }

        return NPV;
    }

    /* The internal rate of return of a time series of cash flows.
     * If irr is the IRR of a set of cash flows, then NPV(irr, cashFlows) should be 0.0.
     *
     * See: http://www.investopedia.com/terms/i/irr.asp
     */
    private static final double xInitial1 = -0.1;
    private static final double xInitial2 = 0.1;
    private static final double xdiffMaximum = 0.00001; // Leave the loop when the divergence is greater than this.
    private static final int stepsMax = 50;
    public double IRR(double[] cashFlows) throws Exception {
        // Computed using the secant method.
        // See:  http://en.wikipedia.org/wiki/Secant_method

        if (cashFlows.length < 3) {
            throw new Exception("We need at least three elements in cashFlows for a good estimate.");
        }

        double xPrevious = xInitial1;
        double yPrevious = NPV(xPrevious, cashFlows);

        double xCurrent = xInitial2;
        double yCurrent = NPV(xCurrent, cashFlows);

        int step = 0;
        for (step = 0; (step < stepsMax) && (Math.abs(xCurrent - xPrevious) >= xdiffMaximum); step++) {
            double xNext = xCurrent - yCurrent * (xCurrent - xPrevious) / (yCurrent - yPrevious);
            double yNext = NPV(xNext, cashFlows);

            if (Double.isInfinite(xNext) || Double.isNaN(xNext)) {
                throw new Exception("IRR really diverged: Reached infinity. I suggest changing the xInitial1, xInitial2 values.");
            }

            xPrevious = xCurrent;
            yPrevious = yCurrent;

            xCurrent = xNext;
            yCurrent = yNext;
        }

        if (step == stepsMax) {
            throw new Exception("IRR diverged: Too many iterations.");
        }

        return xCurrent;
    }
}
