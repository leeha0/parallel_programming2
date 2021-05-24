package parallel.chapter3.escaped;

import java.util.HashSet;
import java.util.Set;

public class EscapedExample {

    // public static 변수는 외부로 유출된다.
    // HashSet 인스턴스 뿐만 아니라 Secret 인스턴스도 함께 공개된다.
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<>();
    }
}
