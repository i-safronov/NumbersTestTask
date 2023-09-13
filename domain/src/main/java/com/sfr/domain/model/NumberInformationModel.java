package com.sfr.domain.model;

import java.io.Serializable;

import io.reactivex.rxjava3.annotations.Nullable;

public class NumberInformationModel implements Serializable {

    private @Nullable String numberInfo;
    private @Nullable String number;

    public NumberInformationModel(String numberInfo, String number) {
        this.numberInfo = numberInfo;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberInfo() {
        return numberInfo;
    }

    public void setNumberInfo(String numberInfo) {
        this.numberInfo = numberInfo;
    }

}
