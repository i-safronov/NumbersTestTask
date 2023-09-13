package com.sfr.data.local.sql.service.number;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface UserNumberHistoryLocalServiceInt {

    Observable<List<UserNumberHistoryEntity>> getUserNumbersHistory();
    UserNumberHistoryEntity saveUserNumberHistory(UserNumberHistoryEntity userNumberHistory);
    UserNumberHistoryEntity getUserNumberHistoryByPrimaryKey(Long primaryKey);

}
