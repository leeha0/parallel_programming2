package parallel.chapter3.immutable;

public class Animal {

    private final Age age;

    public Animal(final Age age) {
        this.age = age;
    }

    public Age getAge() {
        return age;
    }
}
