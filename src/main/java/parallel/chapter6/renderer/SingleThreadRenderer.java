package parallel.chapter6.renderer;

import java.util.ArrayList;
import java.util.List;

public class SingleThreadRenderer {

    void renderPage(CharSequence source) {
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source)) {
            // 이미지를 다운받는 I/O 작업
            imageData.add(imageInfo.downloadImage());
        }
        for (ImageData data : imageData) {
            renderImage(data);
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
