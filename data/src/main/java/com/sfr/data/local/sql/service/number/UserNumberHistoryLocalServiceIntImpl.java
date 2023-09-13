package com.sfr.data.local.sql.service.number;

import android.util.Log;

import com.sfr.data.exception.DataException;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

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
    public UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey) {
        try {
            return userNumberHistoryDao.getUserNumberHistoryByPrimaryKey(primaryKey);
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

}
