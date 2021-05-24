package parallel.chapter3.immutable;

import java.util.HashSet;
import java.util.Set;

import parallel.annotation.Immutable;

@Immutable
public class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
