package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class DeleteUserNumberHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public DeleteUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    void execute(UserNumberHistory userNumberHistory) {
        numberRepositoryInt.deleteUserNumberHistory(userNumberHistory);
    }

}
