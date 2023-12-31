package com.sfr.data.local.sql.dao.db.model_converter;

import com.sfr.data.local.sql.dao.db.model.UserNumberHistoryEntity;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserNumberHistoryEntityConverter {

    public List<UserNumberHistoryEntity> convertListOfUserNumberHistoryToListOfUserNumberHistoryEntity(
            List<UserNumberHistory> list
    ) {
        ArrayList<UserNumberHistoryEntity> mList = new ArrayList<>();
        for (UserNumberHistory user: list) {
            mList.add(
                    new UserNumberHistoryEntity(
                            user.getNumberModel().getNumber(),
                            user.getNumberInformationModel().getNumberInfo(),
                            user.getPrimaryKey()
                    )
            );
        }
        return mList;
    }

    public List<UserNumberHistory> convertListOfUserNumberHistoryEntityToListOfUserNumberHistory(
            List<UserNumberHistoryEntity> list
    ) {
        ArrayList<UserNumberHistory> mList = new ArrayList<>();
        for (UserNumberHistoryEntity userNumberHistoryEntity: list) {
            mList.add(
                    new UserNumberHistory(
                            new NumberModel(userNumberHistoryEntity.getNumber()),
                            new NumberInformationModel(
                                    userNumberHistoryEntity.getNumberInfo(),
                                    userNumberHistoryEntity.getNumber()
                            ),
                            userNumberHistoryEntity.getPrimaryKey()
                    )
            );
        }
        return mList;
    }

    public UserNumberHistoryEntity convertUserNumberHistoryToUserNumberHistoryEntity(
            UserNumberHistory userNumberHistory
    ) {
        return new UserNumberHistoryEntity(
                userNumberHistory.getNumberModel().getNumber(),
                userNumberHistory.getNumberInformationModel().getNumberInfo(),
                userNumberHistory.getPrimaryKey()
        );
    }

    public UserNumberHistory convertUserNumberHistoryEntityToUserNumberHistory(
            @Nullable UserNumberHistoryEntity userNumberHistory
    ) {
        if (userNumberHistory == null) {
            return null;
        }
        return new UserNumberHistory(
                new NumberModel(userNumberHistory.getNumber()),
                new NumberInformationModel(userNumberHistory.getNumberInfo(), userNumberHistory.getNumber()),
                userNumberHistory.getPrimaryKey()
        );
    }

    public NumberInformationModel convertUserNumberHistoryToNumberInformationModel(
            UserNumberHistory userNumberHistory
    ) {
        return new NumberInformationModel(
                userNumberHistory.getNumberInformationModel().getNumberInfo(),
                userNumberHistory.getNumberInformationModel().getNumber()
        );
    }

}
