package com.sfr.domain.model;

public class UserNumberHistory {

    private NumberModel numberModel;
    private NumberInformationModel numberInformationModel;

    public UserNumberHistory(NumberModel numberModel, NumberInformationModel numberInformationModel) {
        this.numberModel = numberModel;
        this.numberInformationModel = numberInformationModel;
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
