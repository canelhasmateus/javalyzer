package io.canelhas.javalyzer.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionalUtils {

    public static <K, U> Map<K, U> lookupWith(Collection<U> c, Function<U, K> keyFn) {

        return lookupWith(c, keyFn, Function.identity());
    }

    private static <K, U, V> Map<K, V> lookupWith(Collection<U> c, Function<U, K> keyFn, Function<U, V> valueFn) {

        final Map<K, V> res = new HashMap<>();

        for (final U u : c) {

            final K key = keyFn.apply(u);
            final V value = valueFn.apply(u);

            res.put(key, value);
        }

        return res;
    }
}
