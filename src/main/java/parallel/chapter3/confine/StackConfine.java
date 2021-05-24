package parallel.chapter3.confine;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class StackConfine {

    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animals 변수는 메서드에 한정되어 있으며, 유출돼서는 안 된다.
        animals = new TreeSet<Animal>(); // new SpeciesGenderComparator()
        animals.addAll(candidates);

        for (Animal a : animals) {
            if (candidate == null || !candidate.isPotentialMate(a)) {
                candidate = a;
            } else {
                // ark.load(new AnimalPair(candidate, a));
                ++numPairs;
                candidate = null;
            }
        }

        return numPairs;
    }
}
