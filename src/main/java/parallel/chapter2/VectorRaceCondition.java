package parallel.chapter2;

import java.util.Vector;

import parallel.annotation.NotThreadSafe;

@NotThreadSafe
public class VectorRaceCondition {

    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();
        Object element = new Object();

        // 없으면 추가하는 put-if-=absent 동작
        // 경쟁 조건 발생
        if (!vector.contains(element)) {
            vector.add(element);
        }
    }
}
