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
    NumberModel numberModel;
    @ColumnInfo
    private @Nullable
    NumberInformationModel numberInformationModel;
    @PrimaryKey(autoGenerate = true)
    private int primaryKey;

    public UserNumberHistoryEntity(@Nullable NumberModel numberModel, @Nullable NumberInformationModel numberInformationModel) {
        this.numberModel = numberModel;
        this.numberInformationModel = numberInformationModel;
    }

    public NumberModel getNumberModel() {
        return numberModel;
    }

    public void setNumberModel(NumberModel numberModel) {
        this.numberModel = numberModel;
    }

    public NumberInformationModel getNumberInformationModel() {
        return numberInformationModel;
    }

    public void setNumberInformationModel(NumberInformationModel numberInformationModel) {
        this.numberInformationModel = numberInformationModel;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

}
