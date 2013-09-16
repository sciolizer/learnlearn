package com.sciolizer.learnlearn.machine;

import java.util.List;
import java.util.Stack;

// First created by Joshua Ball on 9/15/13 at 8:43 PM
public class Machine {
    protected boolean instructionPointerModified;
    protected int instructionPointer;
    protected long time;
    protected long cumulativePayoff;

    public Storage storage;
    public boolean selfModifying;
    public Stack<ProbabilitySnapshot> probabilitySnapshots;

    public void initialize() {
        probabilitySnapshots = new Stack<ProbabilitySnapshot>();
        probabilitySnapshots.push(new ProbabilitySnapshot(
                0,
                0,
                Integer.MAX_VALUE, // undefined
                null,
                0));
    }


    public void halt() {

    }

}
