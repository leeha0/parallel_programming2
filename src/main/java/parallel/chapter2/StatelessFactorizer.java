package parallel.chapter2;

import java.math.BigInteger;

import parallel.annotation.ThreadSafe;

@ThreadSafe
public class StatelessFactorizer implements Servlet {

    // 지역 변수
    // 계산을 위한 일시적인 상태는 스레드의 스택에 저장
    // @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
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
