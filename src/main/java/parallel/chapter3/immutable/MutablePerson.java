package parallel.chapter3.immutable;

public class MutablePerson {

    // 외부에서 값을 변경할 수 있음
    public int age;
    public int name;

    public MutablePerson(int age, int name) {
        this.age = age;
        this.name = name;
    }
}
