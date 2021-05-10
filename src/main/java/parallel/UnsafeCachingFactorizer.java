package parallel;

import parallel.annotation.NotThreadSafe;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public class UnsafeCachingFactorizer {
    // 가장 최근 계산 결과를 캐시에 보관
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void cache(BigInteger i) {
        if (i.equals(lastNumber.get())) {
            // do nothing
        } else {
            // 인수분해
            BigInteger[] factors = factor(i);

            // 마지막 숫자와 인수분해 결과 캐시
            lastNumber.set(i);
            lastFactors.set(factors);
        }
    }

    private BigInteger[] factor(BigInteger i) {
        // 인수분해
        return null;
    }
}
