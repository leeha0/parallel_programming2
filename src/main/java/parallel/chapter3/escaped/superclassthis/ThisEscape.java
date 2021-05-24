package parallel.chapter3.escaped.superclassthis;

public class ThisEscape {

    private String secret = "secret!";

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {

            @Override
            public void onEvent(Event e) {
                secret = "changeSecret!";
            }
        });
    }

    public void print() {
        System.out.println("secret = " + secret);
    }
}
