package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class GetUserNumberHistoryByPrimaryKeyUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumberHistoryByPrimaryKeyUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public UserNumberHistory execute(Long primaryKey) {
        return numberRepositoryInt.getUserNumberHistoryByPrimaryKey(primaryKey);
    }

}
