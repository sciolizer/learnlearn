package com.sciolizer.learnlearn.machine;

import java.util.List;

// First created by Joshua Ball on 9/15/13 at 9:14 PM
public class Executor {

    protected Machine machine;
    protected List<Primitive> primitives;

    public void step() {
        try {
            if (!machine.storage.isProgramArea(machine.instructionPointer)) {
                machine.halt();
                return;
            }
            int i = machine.storage.get(machine.instructionPointer);
            if (i < 0 || primitives.size() <= i) {
                machine.halt();
                return;
            }
            Primitive primitive = primitives.get(i);
            int numberOfArguments = primitive.getNumberOfArguments();
            if (!machine.storage.isProgramArea(i + numberOfArguments)) {
                machine.halt();
                return;
            }
            int first = 0;
            int second = 0;
            int third = 0;
            if (numberOfArguments > 0) {
                first = machine.storage.get(i + 1);
            }
            if (numberOfArguments > 1) {
                second = machine.storage.get(i + 2);
            }
            if (numberOfArguments > 2) {
                third = machine.storage.get(i + 3);
            }
            primitive.execute(machine, first, second, third);
            if (!machine.selfModifying) {
                while (machine.probabilitySnapshots.size() > 1 && !mostUseful()) {
                    popProbabilitySnapshot();
                }
            }
            if (!machine.instructionPointerModified) {
                machine.instructionPointer += numberOfArguments + 1;
            }
        } finally {
            machine.time += 1;
            machine.instructionPointerModified = false;
        }
    }

    protected boolean mostUseful() {

    }

    protected void popProbabilitySnapshot() {
        return null;
    }

}
