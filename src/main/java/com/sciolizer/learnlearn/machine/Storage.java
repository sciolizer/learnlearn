package com.sciolizer.learnlearn.machine;

import com.sciolizer.learnlearn.util.Distribution;
import com.sciolizer.learnlearn.util.IntMap;

import java.util.List;
import java.util.Random;

// First created by Joshua Ball on 9/15/13 at 8:10 PM
public class Storage {
    protected int min; // negative, < inputStart
    protected int inputStart; // negative, <= inputEnd
    protected int inputEnd; // negative, inputEnd - 1 is last inputEnd value
    // registerStart = 0
    protected int programStart; // positive, > registerStart
    protected int max; // positive, > programStart, max - 1 is highest index

    protected int maxInt; // minInt = -1 * maxInt

    protected int numPrimitives;

    protected IntMap<Integer> workArea;
    protected IntMap<Distribution> programArea;

    protected Random random;

    public void initialize() {
        for (int i = min; i < programStart; i++) {
            workArea.put(i, 0);
        }
        for (int i = programStart; i < max; i++) {
            Distribution distribution = new Distribution(numPrimitives, random);
            distribution.initialize();
            programArea.put(i, distribution);
        }
    }

    public int get(int i) {
        if (isWorkArea(i)) {
            return workArea.get(i);
        } else if (isProgramArea(i)) {
            return programArea.get(i).sample();
        } else {
            throw new IllegalArgumentException("invalid memory address");
        }
    }

    public Distribution getDistribution(int i) {
        if (isProgramArea(i)) {
            return programArea.get(i);
        } else {
            throw new IllegalArgumentException("not program area");
        }
    }

    public void set(int i, int value) {
        if (i < min) throw new IllegalArgumentException(i + " < " + min);
        if (i >= max) throw new IllegalArgumentException(i + " >= " + max);
        if (i >= programStart) throw new IllegalArgumentException(i + " >= " + programStart);
        workArea.put(i, value);
    }

    public boolean isWorkArea(int i) {
        return i >= min && i < programStart;
    }

    public boolean isProgramArea(int i) {
        return i >= programStart && i < max;
    }

    public boolean isAddressable(int i) {
        return isWorkArea(i) || isProgramArea(i);
    }
}

