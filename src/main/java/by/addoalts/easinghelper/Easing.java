package by.addoalts.easinghelper;

import lombok.Getter;

import java.util.function.Function;

public final class Easing {
    @Getter
    private final float start, end;
    private final Function<Double, Double> function;
    @Getter
    private final long startTime, duration;

    public Easing(float start, float end, Function<Double, Double> function, long duration) {
        this.start = start;
        this.end = end;
        this.function = function == null? x -> x : function;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public Easing(float start, float end, Function<Double, Double> function, int cooldown) {
        this(start, end, function, (long) Math.abs(((end-start) * cooldown)));
    }

    public float getCurrent() {
        return (float) (((end - start) * function.apply(getProgress())) + start);
    }

    private double getProgress() {
        return Math.max(Math.min((double) (System.currentTimeMillis() - startTime) / duration, 1), 0);
    }

    public boolean isFinished() {
        return getProgress() == 1;
    }
}
