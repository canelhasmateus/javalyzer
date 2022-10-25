package io.canelhas.javalyzer;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.UnaryOperator;

import static java.util.Collections.unmodifiableMap;

public interface Gatherer<T extends Enum<T>> {

    @SafeVarargs
    static <T extends Enum<T>> UnaryOperator<GatheredInfo<T>> enrichWith(Gatherer<T>... gatherers) {
        return currentInfo -> {
            for (final Gatherer<T> gatherer : gatherers) {
                final GatheredInfo<T> newInfo = gatherer.resolve(currentInfo);
                currentInfo = currentInfo.with(newInfo);
            }
            return currentInfo;
        };
    }

    GatheredInfo<T> resolve(GatheredInfo<T> info);

    class GatheredInfo<T extends Enum<T>> {

        private final Class<T> kind;
        private final Map<T, Confidence<Object>> confidences;

        public GatheredInfo(Class<T> kind) {
            confidences = Collections.emptyMap();
            this.kind = kind;
        }

        private GatheredInfo(Class<T> kind, Map<T, Confidence<Object>> confidences) {
            this.confidences = unmodifiableMap(confidences);
            this.kind = kind;
        }

        public static <T extends Enum<T>> GatheredInfo<T> of(Class<T> kind) {
            return new GatheredInfo<>(kind);
        }

        public GatheredInfo<T> with(GatheredInfo<T> that) {
            if (this.equals(that)) {
                return this;
            }

            final Map<T, Confidence<Object>> result = new EnumMap<>(this.kind);
            for (final T key : EnumSet.allOf(this.kind)) {

                final Confidence<Object> thisConfidence = this.get(key);
                final Confidence<Object> thatConfidence = that.get(key);
                final Confidence<Object> best = thatConfidence.level >= thisConfidence.level
                                                ? thatConfidence
                                                : thisConfidence;
                result.put(key, best);

            }
            return new GatheredInfo<>(this.kind, result);
        }

        public GatheredInfo<T> with(T key, Confidence<Object> info) {
            final var objectConfidence = this.get(key);
            if (objectConfidence.level > info.level) {
                return this;
            }

            final Map<T, Confidence<Object>> result = this.confidences.isEmpty()
                                                      ? new EnumMap<>(this.kind)
                                                      : new EnumMap<>(this.confidences);
            result.put(key, info);
            return new GatheredInfo<>(this.kind, result);
        }

        public Confidence<Object> get(T key) {
            final var confidence = confidences.get(key);
            return confidence != null ? confidence
                                      : Confidence.none();
        }

        record Confidence<T>(int level, T value) {

            public static final int LOW = 1;
            public static final int MEDIUM = 3;
            public static final int HIGH = 5;
            private static final Confidence<?> NONE = new Confidence<>(0, null);

            public static <T> Confidence<T> none() {
                return (Confidence<T>) NONE;
            }

            public static <T> Confidence<T> total(T value) {
                return new Confidence<>(Integer.MAX_VALUE, value);
            }

            public static <T> Confidence<T> someConfidence(T object) {
                return new Confidence<>(MEDIUM, object);
            }

            public static <T> Confidence<Object> someConfidence(Optional<T> object) {
                final var value = object.orElse(null);
                if (value != null) {
                    return someConfidence(value);
                }
                return none();
            }
        }

    }

}




