package parallel.chapter5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {

    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        // StringBuilder.append(Object) 메서드로 변환
        // 내부적으로 Iterator 사용 
        System.out.println("DEBUG: added ten elements to " + set);
    }
}
