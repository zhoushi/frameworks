package com.zhou.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/8.
 * 使用Future等待图像下载
 */
public class FutureRenderer {
    
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    
    void renderPage(CharSequence source){
        final List<SingleThreadRenderer.ImageInfo>  imageInfos = scanForImageInfo(source);

        Callable<List<SingleThreadRenderer.ImageData>> task = new Callable<List<SingleThreadRenderer.ImageData>>() {
            @Override
            public List<SingleThreadRenderer.ImageData> call() throws Exception {
                List<SingleThreadRenderer.ImageData> result = new ArrayList<>();
                for (SingleThreadRenderer.ImageInfo imageInfo: imageInfos){
                    result.add(imageInfo.downloadImage());
                }
                return null;
            }
        };
    }

    private List<SingleThreadRenderer.ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }
}
