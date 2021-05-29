package parallel.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import parallel.annotation.NotThreadSafe;

@NotThreadSafe
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}
