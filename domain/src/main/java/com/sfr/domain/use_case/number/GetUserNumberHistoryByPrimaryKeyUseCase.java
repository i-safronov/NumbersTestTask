package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.Optional;

public class GetUserNumberHistoryByPrimaryKeyUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumberHistoryByPrimaryKeyUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public Optional<UserNumberHistory> execute(Long primaryKey) {
        Optional<UserNumberHistory> userNumberHistoryByPrimaryKey = numberRepositoryInt.getUserNumberHistoryByPrimaryKey(primaryKey);
        if (!userNumberHistoryByPrimaryKey.isPresent()) {
            throw new IllegalStateException("userNumberHistoryByPrimaryKey is null");
        }
        return userNumberHistoryByPrimaryKey;
    }

}
