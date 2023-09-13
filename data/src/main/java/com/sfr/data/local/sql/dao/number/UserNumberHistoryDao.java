package com.sfr.data.local.sql.dao.number;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface UserNumberHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveUserNumberHistory(UserNumberHistoryEntity userNumberHistoryEntity);

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE")
    Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory();

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE")
    List<UserNumberHistoryEntity> getUserNumbersHistoryAsList();

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE WHERE primaryKey=:primaryKey")
    @Nullable
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey);

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE WHERE number=:number AND numberInfo=:numberInfo")
    @Nullable
    UserNumberHistoryEntity getUserNumberHistoryByDetails(String number, String numberInfo);

}
