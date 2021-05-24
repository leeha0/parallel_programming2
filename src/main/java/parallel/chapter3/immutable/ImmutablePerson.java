package parallel.chapter3.immutable;

public class ImmutablePerson {

    private final int age;
    private final int name;

    public ImmutablePerson(int age, int name) {
        this.age = age;
        this.name = name;
    }

    // setter 작성 불가능
}
