package com.sfr.data.local.sql.service.number;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;

public interface UserNumberHistoryLocalServiceInt {

    Flowable<List<UserNumberHistoryEntity>> getUserNumbersHistory();
    UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory);
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey);

}
