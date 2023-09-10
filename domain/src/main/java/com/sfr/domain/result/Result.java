package com.sfr.domain.result;

public interface Result<T> {
    void onSuccess(T response);
    void onError(T exception);
}
