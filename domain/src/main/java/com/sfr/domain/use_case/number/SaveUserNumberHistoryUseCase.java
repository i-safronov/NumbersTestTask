package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class SaveUserNumberHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public SaveUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public UserNumberHistory execute(UserNumberHistory userNumberHistory) {

        return numberRepositoryInt.saveUserNumberHistory(userNumberHistory);
    }

}
