package parallel.chapter3.immutable;

import java.util.Arrays;

public class ImmutableArray {

    private final int[] array;

    public ImmutableArray(final int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }


    public int[] getArray() {
        return (array == null) ? null : array.clone();
    }
}
