package parallel.chapter3.escaped;

public class AnonymousClassThis {

    private String secret = "secret!";

    public AnonymousClassThis(AnyClass anyClass) {
        anyClass.registerClass(new AnotherClass() {

            @Override
            public void onRegistered() {
                System.out.println("secret = " + secret);
            }
        });
    }
}
