package com.sfr.data.local.sql.service.number;

import com.sfr.data.exception.DataException;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;

public class UserNumberHistoryLocalServiceIntImpl implements UserNumberHistoryLocalServiceInt {

    private UserNumberHistoryDao userNumberHistoryDao;

    public UserNumberHistoryLocalServiceIntImpl(UserNumberHistoryDao userNumberHistoryDao) {
        this.userNumberHistoryDao = userNumberHistoryDao;
    }

    @Override
    public Flowable<List<UserNumberHistoryEntity>> getUserNumbersHistory() {
        try {
            return userNumberHistoryDao.getUserNumbersHistory();
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory) {
        try {
            userNumberHistoryDao.saveUserNumberHistory(userNumberHistory);
            return getUserNumberHistoryByPrimaryKey(userNumberHistory.getPrimaryKey());
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(int primaryKey) {
        try {
            return userNumberHistoryDao.getUserNumberHistoryByPrimaryKey(primaryKey);
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

}
