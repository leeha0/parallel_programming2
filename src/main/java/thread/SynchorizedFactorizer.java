package thread;

import thread.annotation.ThreadSafe;

import java.math.BigInteger;

@ThreadSafe
public class SynchorizedFactorizer {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;

    public synchronized BigInteger[] getFactors(BigInteger i) {
        if (i.equals(lastNumber)) {
            return lastFactors;
        } else {
            lastNumber = i;
            lastFactors = factors(i);
        }

        return lastFactors;
    }

    private BigInteger[] factors(BigInteger i) {
        // 인수분해
        return null;
    }
}
