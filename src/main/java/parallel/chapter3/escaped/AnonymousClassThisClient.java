package parallel.chapter3.escaped;

public class AnonymousClassThisClient {

    public static void main(String[] args) {
        new AnonymousClassThis(new AnyClass());
    }
}
