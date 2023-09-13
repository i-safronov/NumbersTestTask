package com.sfr.data.repository_impl;

import android.util.Log;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceInt;
import com.sfr.data.network.service.number.NumberRemoteServiceInt;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class NumberRepositoryIntImpl implements NumberRepositoryInt {

    private UserNumberHistoryLocalServiceInt userNumberHistoryLocalServiceInt;
    private UserNumberHistoryEntityConverter userNumberHistoryEntityConverter;
    private NumberRemoteServiceInt numberRemoteServiceInt;

    public NumberRepositoryIntImpl(
            UserNumberHistoryLocalServiceInt userNumberHistoryLocalServiceInt,
            UserNumberHistoryEntityConverter userNumberHistoryEntityConverter,
            NumberRemoteServiceInt numberRemoteServiceInt
    ) {
        this.userNumberHistoryLocalServiceInt = userNumberHistoryLocalServiceInt;
        this.userNumberHistoryEntityConverter = userNumberHistoryEntityConverter;
        this.numberRemoteServiceInt = numberRemoteServiceInt;
    }

    @Override
    public NumberInformationModel getNumberInformation(NumberModel numberModel) {
        return numberRemoteServiceInt.getNumberInformation(numberModel);
    }

    @Override
    public NumberInformationModel getRandomNumberInformation() {
        return numberRemoteServiceInt.getRandomNumberInformation();
    }

    @Override
    public Observable<List<UserNumberHistory>> getUserNumbersHistory() {
        //TODO complete code!
        return userNumberHistoryLocalServiceInt.getUserNumbersHistory().map(
                new Function<List<UserNumberHistoryEntity>, List<UserNumberHistory>>() {
                    @Override
                    public List<UserNumberHistory> apply(List<UserNumberHistoryEntity> userNumberHistoryEntities) throws Throwable {
                        List<UserNumberHistory> userNumberHistories = new ArrayList<>();
                        for (UserNumberHistoryEntity userNumberHistory: userNumberHistoryEntities) {
                            userNumberHistories.add(
                                    new UserNumberHistory(
                                            new NumberModel(userNumberHistory.getNumber()),
                                            new NumberInformationModel(userNumberHistory.getNumberInfo(), userNumberHistory.getNumber()),
                                            userNumberHistory.getPrimaryKey()
                                    )
                            );
                        }
                        Log.d("sfrLog", "apply: " + userNumberHistories.size());
                        return userNumberHistories;
                    }
                }
        );
    }

    @Override
    public UserNumberHistory saveUserNumberHistory(UserNumberHistory userNumberHistory) {
        UserNumberHistoryEntity entity = userNumberHistoryEntityConverter.convertUserNumberHistoryToUserNumberHistoryEntity(userNumberHistory);
        return userNumberHistoryEntityConverter.convertUserNumberHistoryEntityToUserNumberHistory(userNumberHistoryLocalServiceInt.saveUserNumberHistory(entity));
    }

    @Override
    public UserNumberHistory getUserNumberHistoryByPrimaryKey(Long primaryKey) {
        return userNumberHistoryEntityConverter.convertUserNumberHistoryEntityToUserNumberHistory(userNumberHistoryLocalServiceInt.getUserNumberHistoryByPrimaryKey(primaryKey));
    }

    @Override
    public UserNumberHistory getUserNumberHistoryByDetails(String number, String numberInfo) {
        return userNumberHistoryEntityConverter.convertUserNumberHistoryEntityToUserNumberHistory(userNumberHistoryLocalServiceInt.getUserNumberHistoryByDetails(number, numberInfo));
    }

}
