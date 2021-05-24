package parallel.chapter3.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList {

    private final List<Animal> animals;

    public ImmutableList(final List<Animal> animals) {
        this.animals = new ArrayList<>(animals);
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}
