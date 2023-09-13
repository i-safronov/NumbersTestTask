package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class DeleteUserNumberHistoryUseCaseByDetails {

    private NumberRepositoryInt numberRepositoryInt;

    public DeleteUserNumberHistoryUseCaseByDetails(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    void execute(UserNumberHistory userNumberHistory) {
        numberRepositoryInt.deleteUserNumberHistoryByDetails(userNumberHistory);
    }

}
