package com.sfr.domain.model;

import java.io.Serializable;

import io.reactivex.rxjava3.annotations.Nullable;

public class NumberModel implements Serializable {

    private @Nullable String number;

    public NumberModel(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
