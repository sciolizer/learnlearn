package com.sciolizer.learnlearn.machine;

import com.sciolizer.learnlearn.util.Distribution;

// First created by Joshua Ball on 9/15/13 at 9:08 PM
public class ProbabilitySnapshot {
    public final int time;
    public final long payoff;
    public final int programCell;
    public final Distribution.Restoration restoration;
    public final int first; // stack index

    public ProbabilitySnapshot(int time, long payoff, int programCell, Distribution.Restoration restoration, int first) {
        this.time = time;
        this.payoff = payoff;
        this.programCell = programCell;
        this.restoration = restoration;
        this.first = first;
    }
}
