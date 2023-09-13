package com.sfr.domain.repository;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface NumberRepositoryInt {

    NumberInformationModel getNumberInformation(NumberModel numberModel);
    NumberInformationModel getRandomNumberInformation();

    Observable<List<UserNumberHistory>> getUserNumbersHistory();
    UserNumberHistory saveUserNumberHistory(UserNumberHistory userNumberHistory);
    UserNumberHistory getUserNumberHistoryByPrimaryKey(Long primaryKey);

}
