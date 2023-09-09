package com.sfr.data.repository_impl;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;
import com.sfr.domain.result.Result;

public class NumberRepositoryIntImpl implements NumberRepositoryInt {

    //TODO complete code

    @Override
    public NumberInformationModel getNumberInformation(NumberModel numberModel) {
        return null;
    }

    @Override
    public NumberInformationModel getRandomNumberInformation() {
        return null;
    }

    @Override
    public void getUserNumbersHistory(Result<NumberInformationModel> result) {

    }

    @Override
    public void saveUserNumberHistory(UserNumberHistory userNumberHistory, Result<UserNumberHistory> result) {

    }

}
