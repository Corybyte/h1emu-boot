package com.example.util;

import com.example.H1emuBoot;
import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @Author 写你的名字
 * @Date 2022/11/3 上午3:41 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
public class HttpClient {
    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    public static String httpGet(String url) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public static String httpPost(String url, String json) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

}
