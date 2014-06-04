package com.gridpoint.energy.util.profile.timer;

/**
 * Class to assist with profiling a slow method.
 * 
 * <pre>
 * public void methodUnderReview() {
 *     ThreadTimer.remove(); // clear any lingering timers in case the thread is reused
 *     Timer timer = ThreadTimer.get();
 *     timer.start(&quot;methodUnderReview - totalTime&quot;);
 *     timer.start(&quot;methodUnderReview - fastCall&quot;);
 *     fastCall();
 *     timer.stop();
 *     timer.start(&quot;methodUnderReview - slowCall&quot;);
 *     slowCall();
 *     timer.stop();
 *     timer.stop();
 *     log.debug(timer.dump());
 * }
 * 
 * public void slowCall() {
 *     Timer timer = ThreadTimer.get();
 *     timer.start(&quot;slowCall - first&quot;);
 *     first();
 *     timer.stop();
 *     timer.start(&quot;slowCall - second&quot;);
 *     second();
 *     timer.stop();
 * }
 * </pre>
 * 
 * Will output something like the following to the log
 * 
 * <pre>
 * methodUnderReview - totalTime...  2192
 * methodUnderReview - slowCall....  2190
 * slowCall - first................  1090
 * slowCall - second...............   100
 * methodUnderReview - fastCall....     1
 * </pre>
 * 
 * Which signals a closer look at first() is needed
 * 
 * @author DWC
 */
public class ThreadTimer {
    private static final ThreadLocal<Timer> threadTimer = new ThreadLocal<Timer>() {
        @Override
        protected Timer initialValue() {
            return new Timer();
        };
    };

    public static Timer get() {
        return threadTimer.get();
    }

    public static void remove() {
        threadTimer.remove();
    }
}
