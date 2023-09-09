package com.sfr.data.local.sql.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import com.sfr.data.local.sql.db.model.UserNumberHistoryEntity;

@Database(entities = {UserNumberHistoryEntity.class}, version = 1)
public abstract class UserNumberHistoryDB extends RoomDatabase {
    public abstract UserNumberHistoryDao userNumberHistoryDao();
}
