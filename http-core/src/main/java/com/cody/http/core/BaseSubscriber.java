/*
 * ************************************************************
 * 文件：BaseSubscriber.java  模块：http-core  项目：component
 * 当前修改时间：2019年04月23日 18:23:20
 * 上次修改时间：2019年04月13日 08:44:03
 * 作者：Cody.yi   https://github.com/codyer
 *
 * 描述：http-core
 * Copyright (c) 2019
 * ************************************************************
 */

package com.cody.http.core;

import com.cody.http.core.callback.RequestCallback;
import com.cody.http.core.callback.RequestMultiplyCallback;
import com.cody.http.lib.config.HttpCode;
import com.cody.http.lib.exception.TokenInvalidException;
import com.cody.http.lib.exception.base.BaseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by xu.yi. on 2019/4/6.
 */
public class BaseSubscriber<T> extends DisposableObserver<T> {

    private final RequestCallback<T> requestCallback;

    BaseSubscriber(RequestCallback<T> requestCallback) {
        this.requestCallback = requestCallback;
    }

    @Override
    public void onNext(T t) {
        if (requestCallback != null) {
            requestCallback.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (requestCallback instanceof RequestMultiplyCallback) {
            RequestMultiplyCallback callback = (RequestMultiplyCallback) requestCallback;
            if (e instanceof BaseException) {
                callback.onFail((BaseException) e);
            } else if (e instanceof HttpException) {
                if (((HttpException) e).code() == HttpCode.CODE_TOKEN_INVALID) {
                    callback.onFail(new TokenInvalidException());
                } else {
                    callback.onFail(new BaseException(((HttpException) e).code(), e.getMessage()));
                }
            } else {
                callback.onFail(new BaseException(HttpCode.CODE_UNKNOWN, e.getMessage()));
            }
        } else {
            if (requestCallback != null) {
                requestCallback.showToast(e.getMessage());
            }
        }
    }

    @Override
    public void onComplete() {

    }

}