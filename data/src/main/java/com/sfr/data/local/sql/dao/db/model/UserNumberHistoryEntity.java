package com.sfr.data.local.sql.dao.db.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;

@Entity(tableName = "USER_NUMBER_HISTORY_TABLE")
public class UserNumberHistoryEntity {

    @ColumnInfo
    private @Nullable
    String number;
    @ColumnInfo
    private @Nullable
    String numberInfo;
    @PrimaryKey(autoGenerate = true)
    private int primaryKey;

    public UserNumberHistoryEntity(@Nullable String number, @Nullable String numberInfo, int primaryKey) {
        this.number = number;
        this.numberInfo = numberInfo;
        this.primaryKey = primaryKey;
    }

    @Nullable
    public String getNumber() {
        return number;
    }

    public void setNumber(@Nullable String number) {
        this.number = number;
    }

    @Nullable
    public String getNumberInfo() {
        return numberInfo;
    }

    public void setNumberInfo(@Nullable String numberInfo) {
        this.numberInfo = numberInfo;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }
}
