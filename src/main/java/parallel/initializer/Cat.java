package parallel.initializer;

public class Cat extends Pet {

    final int i_value;
    static int s_value;

    {
        System.out.println("instance initializer block");
        i_value = 3;
        System.out.println("i_value: " + i_value);
        System.out.println("s_value: " + s_value);
    }

    static {
        System.out.println("static initalizer block");
        // System.out.println("i_value: " + i_value); // 저적 초기화 블록에서 접근 안됨
        System.out.println("s_value: " + s_value);
    }

    public Cat() {
        System.out.println("constructor: Cat");
    }
}
