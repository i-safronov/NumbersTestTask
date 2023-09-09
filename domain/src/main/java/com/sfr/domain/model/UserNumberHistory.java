package com.sfr.domain.model;

public class UserNumberHistory {

    private NumberModel numberModel;
    private NumberInformationModel numberInformationModel;
    private int primaryKey;

    public UserNumberHistory(NumberModel numberModel, NumberInformationModel numberInformationModel, int primaryKey) {
        this.numberModel = numberModel;
        this.numberInformationModel = numberInformationModel;
        this.primaryKey = primaryKey;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
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
