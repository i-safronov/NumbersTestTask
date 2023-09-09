package com.sfr.data.local.sql.dao.number;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface UserNumberHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUserNumberHistory(UserNumberHistoryEntity userNumberHistoryEntity);

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE")
    Flow<List<UserNumberHistoryEntity>> getUserNumbersHistory();

    @Query("SELECT * FROM USER_NUMBER_HISTORY_TABLE WHERE primaryKey=:primaryKey")
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(int primaryKey);

}
