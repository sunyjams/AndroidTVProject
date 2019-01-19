package com.sunyjams.domain.http;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.sunyjams.domain.sys.log.MyLog;

import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava2.HttpException;

/**
 * 发起网络请求的类
 *
 * @param <T>
 */
public abstract class HttpRequest<T> {

    private static final int ERROR = 0x02;

    private final String TAG = getClass().getSimpleName();

    public HttpRequest() {
    }

    public Map<String, Object> createJson() {
        return null;
    }


    /**
     * 获取正常返回，子类重写此方法
     *
     * @param t
     */
    protected abstract void onSuccess(T t);

    /**
     * 默认弹出 Toast ，子类要处理请求失败，重写此方法
     *
     * @param code
     * @param msg
     */
    protected abstract void onFail(int code, String msg);

    /**
     * 发起一般的网络请求
     *
     * @param clazz
     * @param methodName
     */
    public synchronized void post(Class<?> clazz, String methodName) {

        String json = JSON.toJSONString(createJson());

        if (TextUtils.isEmpty(json)) {
            return;
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse(HttpConst.MEDIA_TYPE_FORMAT_JSON), json);

        Observable observable = null;

        try {
            Method method = clazz.getMethod(methodName, RequestBody.class);
            Object service = RetroManager.getInstance().createService(clazz);
            observable = (Observable) method.invoke(service, requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (observable == null) {
            throw new IllegalArgumentException("observable can not be null");
        }
        subscriber(observable, subscriber);
    }

    public synchronized void get(Class<?> clazz, String methodName){
        Observable observable = null;
        try{
            Method method = clazz.getMethod(methodName, Map.class);
            Object service = RetroManager.getInstance().createService(clazz);
            observable = (Observable) method.invoke(service, createJson());
        }catch (Exception e){
            e.printStackTrace();
        }

        if (observable == null) {
            throw new IllegalArgumentException("observable can not be null");
        }
        subscriber(observable, subscriber);
    }

    private Observer<T> subscriber = new Observer<T>() {
        @Override
        public void onComplete() {

        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onError(Throwable e) {
            MyLog.e(TAG, "error=========>" + e.getMessage());
            e.printStackTrace();
            if (e instanceof HttpException) {
                onFail(ERROR, "服务器错误");
            } else if (e instanceof UnknownHostException || e instanceof ConnectException) {
                onFail(ERROR, "连接失败，请检查网络");
            } else {
                onFail(ERROR, e.getMessage());
            }
        }

        @Override
        public void onNext(T t) {
            handleResult(t);
        }
    };

    private synchronized static <T> void subscriber(Observable<T> o, Observer<? super T> subscriber) {
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private void handleResult(T t) {
        onSuccess((T) t);
    }
}
