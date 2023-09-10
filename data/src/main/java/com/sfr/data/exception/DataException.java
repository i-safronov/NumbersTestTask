package com.sfr.data.exception;

import androidx.annotation.Nullable;

public class DataException extends RuntimeException {

    public DataException(
            @Nullable String msg, @Nullable Throwable causeT
    ) {
        super(msg, causeT);
    }

    public DataException() {
        super();
    }

}
