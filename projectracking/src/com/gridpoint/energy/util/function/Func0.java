package com.gridpoint.energy.util.function;

/**
 * An interface for objects which represent a function of zero arguments.
 * 
 * @author DWC
 */
public interface Func0<A> {

    /**
     * Evaluate this function and return the result.
     * 
     * @return the <code>A</code> result of evaluating this function
     */
    A apply();

}
