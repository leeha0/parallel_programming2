package parallel.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import parallel.annotation.ThreadSafe;

@ThreadSafe
public class SafetyListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
