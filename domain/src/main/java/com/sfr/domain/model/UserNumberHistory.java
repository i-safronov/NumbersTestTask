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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != UserNumberHistory.class) return false;
        UserNumberHistory obj1 = (UserNumberHistory) obj;
        return numberModel.equals(obj1.getNumberModel()) && numberInformationModel.equals(obj1.getNumberInformationModel()) && primaryKey.equals(obj1.getPrimaryKey());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
