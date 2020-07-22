package thread;

import thread.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0L);

    public long getCount() {
        return count.get();
    }

    public long incrementAndGet() {
        return count.incrementAndGet();
    }
}
