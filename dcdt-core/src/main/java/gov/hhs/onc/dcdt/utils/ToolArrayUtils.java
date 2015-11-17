package gov.hhs.onc.dcdt.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.apache.commons.lang3.ArrayUtils;

public abstract class ToolArrayUtils {
    @Nullable
    public static <T> T[] slice(@Nullable T[] arr, int index) {
        return (arr != null) ? (ToolNumberUtils.isPositive(index) ? ArrayUtils.subarray(arr, index, arr.length) : ArrayUtils.subarray(arr, 0, arr.length
            + index)) : null;
    }

    @Nullable
    public static <T> T[] emptyToNull(@Nullable T[] arr) {
        return ArrayUtils.isEmpty(arr) ? null : arr;
    }

    @Nullable
    public static <T> T getFirst(@Nullable T[] arr) {
        return getFirst(arr, null);
    }

    @Nullable
    @SuppressWarnings({ "ConstantConditions" })
    public static <T> T getFirst(@Nullable T[] arr, @Nullable T defaultIfEmpty) {
        return !ArrayUtils.isEmpty(arr) ? arr[0] : defaultIfEmpty;
    }

    @Nullable
    public static <T> T[] removeFirst(@Nullable T[] arr) {
        return !ArrayUtils.isEmpty(arr) ? ArrayUtils.remove(arr, 0) : arr;
    }

    @Nullable
    public static <T> T getLast(@Nullable T[] arr) {
        return getLast(arr, null);
    }

    @Nullable
    @SuppressWarnings({ "ConstantConditions" })
    public static <T> T getLast(@Nullable T[] arr, @Nullable T defaultIfEmpty) {
        return !ArrayUtils.isEmpty(arr) ? arr[arr.length - 1] : defaultIfEmpty;
    }

    @SuppressWarnings({ "ConstantConditions" })
    public static <T> T[] removeLast(@Nullable T[] arr) {
        return !ArrayUtils.isEmpty(arr) ? ArrayUtils.remove(arr, arr.length - 1) : arr;
    }

    @SafeVarargs
    @SuppressWarnings({ "varargs" })
    public static <T> List<T> asList(@Nullable T ... items) {
        return asCollection(ArrayList::new, items);
    }

    @SafeVarargs
    @SuppressWarnings({ "varargs" })
    public static <T> Set<T> asSet(@Nullable T ... items) {
        return asCollection(HashSet::new, items);
    }

    @SafeVarargs
    @SuppressWarnings({ "varargs" })
    public static <T, U extends Collection<T>> U asCollection(IntFunction<U> collSupplier, @Nullable T ... items) {
        return (ArrayUtils.isEmpty(items) ? collSupplier.apply(0) : Stream.of(items).collect(Collectors.toCollection(() -> collSupplier.apply(items.length))));
    }
}
