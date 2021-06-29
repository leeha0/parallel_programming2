package parallel.chapter6.renderer;

import static java.util.concurrent.TimeUnit.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class AdRenderer {

    private static final long TIME_BUDGET = 1000;
    private static final Ad DEFAULT_AD = new Ad();

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Page renderPageWithAd() throws InterruptedException {
        long endNanos = System.nanoTime() + TIME_BUDGET;
        // 광고를 불러오는 작업 등록
        Future<Ad> f = executor.submit(new FetchAdTask());
        // 페이지 렌딩 작업 진행
        Page page = renderPageBody();
        Ad ad;
        try {
            // 광고를 불러오는 작업에 시간 제한 요구사항 적용
            long timeLeft = endNanos - System.nanoTime();
            ad = f.get(timeLeft, NANOSECONDS);
        } catch (ExecutionException e) {
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {
            ad = DEFAULT_AD;
            // 시간 제한 요구사항을 만족하지 못하면 광고 불러오는 작업 취소
            f.cancel(true);
        }
        page.setAd(ad);
        return page;
    }

    private Page renderPageBody() {
        return null;
    }
}
