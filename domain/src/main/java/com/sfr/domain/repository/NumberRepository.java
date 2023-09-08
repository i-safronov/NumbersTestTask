package com.sfr.domain.repository;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.result.Result;

public interface NumberRepository {
    void getNumberInformation(NumberModel numberModel, Result<NumberInformationModel> result);
    void getRandomNumberInformation(Result<NumberInformationModel> result);
    void getUserNumbersHistory(Result<NumberInformationModel> result);
    void saveUserNumberHistory(UserNumberHistory userNumberHistory, Result<UserNumberHistory> result);
}
