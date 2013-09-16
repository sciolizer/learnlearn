package com.sciolizer.learnlearn.machine;

import java.util.concurrent.atomic.AtomicInteger;

// First created by Joshua Ball on 9/15/13 at 8:27 PM
public interface Primitive {
    int getNumberOfArguments();
    void execute(Machine machine, int arg1, int arg2, int arg3);
}
