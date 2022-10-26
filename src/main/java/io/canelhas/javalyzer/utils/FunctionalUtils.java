package io.canelhas.javalyzer.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionalUtils {

    public static <K, U> Map<K, U> lookupWith(Collection<U> c, Function<U, K> keyFn) {

        return lookupWith(c, keyFn, Function.identity());
    }

    public static <K, U, V> Map<K, V> lookupWith(Collection<U> c, Function<U, K> keyFn, Function<U, V> valueFn) {

        final Map<K, V> res = new HashMap<>();

        for (final var u : c) {

            final var key = keyFn.apply(u);
            final var value = valueFn.apply(u);

            res.put(key, value);
        }

        return res;
    }

    public static <K, U, V> Map<K, V> lookupWithAll(Collection<U> c, Function<U, V> valueFn, Function<U, K>... keyFns) {

        final Map<K, V> res = new HashMap<>();

        for (final var u : c) {

            final var value = valueFn.apply(u);

            for (var keyFn : keyFns) {
                final var key = keyFn.apply(u);
                res.put(key, value);
            }
        }

        return res;
    }
}
