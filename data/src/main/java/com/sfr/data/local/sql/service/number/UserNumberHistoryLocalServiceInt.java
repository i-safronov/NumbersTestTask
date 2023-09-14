package com.sfr.data.local.sql.service.number;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

import io.reactivex.rxjava3.core.Observable;

public interface UserNumberHistoryLocalServiceInt {

    Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory();
    Optional<UserNumberHistoryEntity> saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory);
    Optional<UserNumberHistoryEntity> getUserNumberHistoryByPrimaryKey(Long primaryKey);
    List<UserNumberHistoryEntity> getUserNumbersHistoryAsList();
    Optional<UserNumberHistoryEntity> getUserNumberHistoryByDetails(String number);
    void deleteUserNumberHistoryEntityByDetails(String number);

}
