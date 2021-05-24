package parallel.chapter3.escaped.superclassthis;

public class EventSource {

    public void registerListener(EventListener eventListener) {
        eventListener.onEvent(new Event());
    }
}
