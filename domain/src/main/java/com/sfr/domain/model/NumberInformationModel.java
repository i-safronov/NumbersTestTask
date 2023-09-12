package com.sfr.domain.model;

public class NumberInformationModel {

    private String numberInfo;
    private String number;

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
