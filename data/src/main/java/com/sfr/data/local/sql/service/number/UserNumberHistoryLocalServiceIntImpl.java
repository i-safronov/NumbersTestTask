package com.sfr.data.local.sql.service.number;

import com.sfr.data.exception.DataException;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import java.util.List;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;

public class UserNumberHistoryLocalServiceIntImpl implements UserNumberHistoryLocalServiceInt {

    private UserNumberHistoryDao userNumberHistoryDao;

    public UserNumberHistoryLocalServiceIntImpl(UserNumberHistoryDao userNumberHistoryDao) {
        this.userNumberHistoryDao = userNumberHistoryDao;
    }

    @Override
    public Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory() {
        try {
            return userNumberHistoryDao.getUserNumbersHistory();
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory) {
        try {
            Long primaryKey = userNumberHistoryDao.saveUserNumberHistory(userNumberHistory);
            return getUserNumberHistoryByPrimaryKey(primaryKey);
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    @Nullable
    public UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey) {
        try {
            return userNumberHistoryDao.getUserNumberHistoryByPrimaryKey(primaryKey);
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public List<UserNumberHistoryEntity> getUserNumbersHistoryAsList() {
        return userNumberHistoryDao.getUserNumbersHistoryAsList();
    }

    @Override
    @Nullable
    public UserNumberHistoryEntity getUserNumberHistoryByDetails(String number) {
        return userNumberHistoryDao.getUserNumberHistoryByDetails(number);
    }

    @Override
    public void deleteUserNumberHistoryEntityByDetails(String number) {
        userNumberHistoryDao.deleteUserNumberHistoryEntityByDetails(number);
    }

}
