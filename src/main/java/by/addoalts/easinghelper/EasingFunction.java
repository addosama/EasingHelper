package by.addoalts.easinghelper;

import java.util.function.Function;

public interface EasingFunction extends Function<Double, Double> {
    Double apply(Double x);

    EasingFunction EASE_IN_SINE = x -> 1 - Math.cos((x * Math.PI) / 2);
    EasingFunction EASE_OUT_SINE = x -> Math.sin((x * Math.PI) / 2);
    EasingFunction EASE_IN_OUT_SINE = x -> -(Math.cos(Math.PI * x) - 1) / 2;
}
