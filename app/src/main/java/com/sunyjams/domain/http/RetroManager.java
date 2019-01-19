package com.sunyjams.domain.http;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunyjams.domain.config.APIConfig;
import com.sunyjams.domain.sys.log.MyLog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 45820 on 2016/11/5.
 *
 * @Update 修改了一些 Request 参数 By James
 * @date 2017/12/13
 */
public class RetroManager {

    private static volatile RetroManager instance = null;

    private static final int DEFAULT_READ_TIMEOUT = 50 * 1000;
    private static final int DEFAULT_CONNECT_TIMEOUT = 50 * 1000;
    private static final int DEFAULT_WRITE_TIMEOUT = 50 * 1000;

    private Retrofit retrofit;
    private Gson gson;
    private OkHttpClient client;

    private RetroManager() {
        initGson();
        initOkHttpClient();
        initRetrofit();
    }

    public static RetroManager getInstance() {
        if (instance == null) {
            synchronized (RetroManager.class) {
                if (instance == null) {
                    instance = new RetroManager();
                }
            }
        }
        return instance;
    }

    private void initRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(APIConfig.BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
    }

    HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            MyLog.i("RequestInterceptor", "message====" + message);
        }
    });

    private void initOkHttpClient() {
        if (client == null) {
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder()
                    .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                    .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                    .addInterceptor(new RequestInterceptor())
                    .addInterceptor(logInterceptor)
                    .addNetworkInterceptor(new NetworkInterceptor())
                    .build();
        }
    }

    public class RequestInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            Map<String, Object> requestMap = new HashMap<>();
            try {
                Request copy = original.newBuilder().build();
                Buffer buffer = new Buffer();
                copy.body().writeTo(buffer);
                String requestJson = buffer.readUtf8();
                requestMap.clear();
                requestMap.putAll(JSON.parseObject(requestJson));
            } catch (final Exception e) {
                MyLog.i("RequestBody解析错误");
            }

            Request request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build();

            MyLog.i("RequestInterceptor", String.format("发送请求 %s ",
                    request.body()));
            return chain.proceed(request);
        }
    }

    public class NetworkInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            if (response.code() != 200) {
                // TODO 返回状态码不为200时处理
                MyLog.i("response status is not 200");
            }
            return response;
        }
    }

    private void initGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
    }

    public <T> T createService(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
