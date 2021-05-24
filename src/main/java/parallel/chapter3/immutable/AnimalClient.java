package parallel.chapter3.immutable;

public class AnimalClient {

    public static void main(String[] args) {
        Age age = new Age(1);
        Animal animal = new Animal(age);

        System.out.println(animal.getAge().getValue());
        // Output: 1

        animal.getAge().setValue(10);
        System.out.println(animal.getAge().getValue());
        // Output: 10
    }
}
