package com.sfr.domain.model;

import io.reactivex.rxjava3.annotations.Nullable;

public class UserNumberHistory {

    @Nullable
    private NumberModel numberModel;
    @Nullable
    private NumberInformationModel numberInformationModel;
    @Nullable
    private Long primaryKey;

    public UserNumberHistory(NumberModel numberModel, NumberInformationModel numberInformationModel, Long primaryKey) {
        this.numberModel = numberModel;
        this.numberInformationModel = numberInformationModel;
        this.primaryKey = primaryKey;
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public NumberInformationModel getNumberInformationModel() {
        return numberInformationModel;
    }

    public void setNumberInformationModel(NumberInformationModel numberInformationModel) {
        this.numberInformationModel = numberInformationModel;
    }

    public NumberModel getNumberModel() {
        return numberModel;
    }

    public void setNumberModel(NumberModel numberModel) {
        this.numberModel = numberModel;
    }

}
