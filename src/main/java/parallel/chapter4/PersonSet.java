package parallel.chapter4;

import java.util.HashSet;
import java.util.Set;

import parallel.annotation.ThreadSafe;

@ThreadSafe
public class PersonSet {

    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    private class Person {

    }
}
