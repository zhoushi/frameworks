package com.zhou.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/8.
 */
public class SingleThreadRenderer {

        //顺序地渲染页面元素'
    void renderPage(CharSequence source){
        renderText(source);

        List<ImageData> imageInfo = new ArrayList<>();

        List<ImageData> scanForImageInfo = new ArrayList<>();
        scanForImageInfo.stream().collect(Collectors.toList());
    }
    //文本
    private void renderText(CharSequence source) {
    }

    static class ImageData{

        private String uri;
        private String name;
    }

    public class ImageInfo {

        ImageData downloadImage(){
            return null;
        }
    }
}
