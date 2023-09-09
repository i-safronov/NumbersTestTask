package com.sfr.data.local.sql.dao.number;

import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface UserNumberHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUserNumberHistory(UserNumberHistoryEntity userNumberHistoryEntity);

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE")
    Flowable<List<UserNumberHistoryEntity>> getUserNumbersHistory();

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE WHERE primaryKey=:primaryKey")
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(int primaryKey);

}
