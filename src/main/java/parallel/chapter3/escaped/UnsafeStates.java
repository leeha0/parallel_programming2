package parallel.chapter3.escaped;

public class UnsafeStates {

    private String[] states = new String[]{
        "AK", "AL"
    };

    // 접근자를 통해 외부로 유출된다.
    public String[] getStates() {
        return states;
    }
}
