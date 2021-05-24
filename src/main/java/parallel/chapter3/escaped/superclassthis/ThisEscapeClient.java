package parallel.chapter3.escaped.superclassthis;

public class ThisEscapeClient {

    public static void main(String[] args) {
        ThisEscape thisEscape = new ThisEscape(new EventSource());
        thisEscape.print();
    }
}
