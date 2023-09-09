package com.sfr.data.local.sql.service.number;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

public interface UserNumberHistoryLocalServiceInt {

    Flow<List<UserNumberHistoryEntity>> getUserNumbersHistory();
    UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory);
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(int primaryKey);

}
