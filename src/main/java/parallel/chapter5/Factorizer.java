package parallel.chapter5;

import java.math.BigInteger;

import parallel.chapter2.Servlet;
import parallel.chapter2.ServletRequest;
import parallel.chapter2.ServletResponse;

public class Factorizer implements Servlet {

    private final Computable<BigInteger, BigInteger[]> c =
        new Computable<BigInteger, BigInteger[]>() {
            @Override
            public BigInteger[] compute(BigInteger arg) throws InterruptedException {
                return factor(arg);
            }
        };
    private final Computable<BigInteger, BigInteger[]> cache =
        new Memoizer<>(c);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    private void encodeError(ServletResponse resp, String message) {
    }
}
