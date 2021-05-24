package parallel.chapter3.escaped;

public class ThisEscape {

    private String secret;

    public ThisEscape(EventSource source) {
        source.registerListener(
            // 인자를 통한 부모 클래스 유출
            // 내부 클래스는 항상 부모 클래스에 대한 참조를 갖고 있다.
            new EventListener() {
                @Override
                public void onEvent(Event e) {
                    System.out.println("secret = " + secret);
                    // doSomething(e);
                }
            }
        );
    }
}
