package com.sfr.domain.repository;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.result.Result;

public interface NumberRepositoryInt {

    NumberInformationModel getNumberInformation(NumberModel numberModel);
    NumberInformationModel getRandomNumberInformation();

    void getUserNumbersHistory(Result<NumberInformationModel> result);
    void saveUserNumberHistory(UserNumberHistory userNumberHistory, Result<UserNumberHistory> result);

}
