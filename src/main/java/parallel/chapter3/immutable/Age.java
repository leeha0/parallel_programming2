package parallel.chapter3.immutable;

public class Age {

    private int value;

    public Age(final int value) {
        this.value = value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
