package com.sfr.data.local.sql.service.number;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface UserNumberHistoryLocalServiceInt {

    Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory();
    UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory);
    @Nullable
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey);
    List<UserNumberHistoryEntity> getUserNumbersHistoryAsList();
    @Nullable
    UserNumberHistoryEntity getUserNumberHistoryByDetails(String number, String numberInfo);
    void deleteUserNumberHistoryEntity(UserNumberHistoryEntity userNumberHistoryEntity);

}
