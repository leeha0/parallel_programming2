package parallel.chapter6.renderer;

import static parallel.chapter5.Preloader.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureRenderer {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    void renderPage(CharSequence source) {
        final ImageInfo[] imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task =
            new Callable<List<ImageData>>() {
                @Override
                public List<ImageData> call() throws Exception {
                    List<ImageData> result = new ArrayList<>();
                    for (ImageInfo imageInfo : imageInfos) {
                        result.add(imageInfo.downloadImage());
                    }
                    return result;
                }
            };

        Future<List<ImageData>> future = executor.submit(task);
        renderText(source);

        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            // 스레드의 인터럽트 상태를 재설정
            Thread.currentThread().interrupt();
            // 결과는 더 이상 필요없으니 해당 작업도 취소한다.
            future.cancel(true);
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }
    }

    private ImageInfo[] scanForImageInfo(CharSequence source) {
        return null;
    }

    private void renderText(CharSequence source) {
        // 문자열 렌딩
    }

    private void renderImage(ImageData data) {
        // 이미지 렌딩
    }
}
