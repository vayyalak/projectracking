package com.gridpoint.energy.util.function;

/**
 * A function from <code>A</code>s to <code>B</code>.
 * 
 * @author DWC
 */
public interface Func1<A, B> {

    /**
     * Apply this function to <code>a</code> and return the result.
     * 
     * @param a
     *            - the single parameter to this function.
     * @return the result of applying this function to <code>a</code>
     */
    B apply(A a);
}
