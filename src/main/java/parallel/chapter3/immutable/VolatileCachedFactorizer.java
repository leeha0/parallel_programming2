package parallel.chapter3.immutable;

import java.math.BigInteger;

import parallel.annotation.ThreadSafe;
import parallel.chapter2.Servlet;
import parallel.chapter2.ServletRequest;
import parallel.chapter2.ServletResponse;

@ThreadSafe
public class VolatileCachedFactorizer implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getFactors(i);

        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(resp, factors);
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }
}
