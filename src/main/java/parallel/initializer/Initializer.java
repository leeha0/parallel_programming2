package parallel.initializer;

public class Initializer {

    public static void main(String[] args) {
        Cat.s_value = 5; // 정적 초기화 블록 호출
        System.out.println("s_value: " + Cat.s_value);

        System.out.println("Cat 객체 생성");
        Cat cat1 = new Cat();

        System.out.println("Cat 객체 생성");
        Cat cat2 = new Cat();
    }
}
