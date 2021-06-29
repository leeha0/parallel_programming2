package parallel.chapter6.renderer.completionservice;

import static parallel.chapter5.Preloader.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import parallel.chapter6.renderer.ImageData;
import parallel.chapter6.renderer.ImageInfo;

public class Renderer {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    void renderPage(CharSequence source) {
        final List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>() {
                public ImageData call() {
                    return imageInfo.downloadImage();
                }
            });
        }

        renderText(source);

        try {
            for (int t = 0, n = info.size(); t < n; t++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            launderThrowable(e.getCause());
        }
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }

    private void renderText(CharSequence source) {
        // 문자열 렌딩
    }

    private void renderImage(ImageData data) {
        // 이미지 렌딩
    }
}
