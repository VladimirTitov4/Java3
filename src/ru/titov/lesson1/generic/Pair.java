package ru.titov.lesson1.generic;

public class Pair<L, R> {

    private final L valueLeft;
    private final R valueRight;

    public Pair(L valueLeft, R valueRight) {
        this.valueLeft = valueLeft;
        this.valueRight = valueRight;
    }

    public L getValueLeft() {
        return valueLeft;
    }

    public R getValueRight() {
        return valueRight;
    }
}
