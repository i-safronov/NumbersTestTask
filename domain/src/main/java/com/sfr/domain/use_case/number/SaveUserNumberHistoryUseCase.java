package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class SaveUserNumberHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;
    private GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase;

    public SaveUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt /*  GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase */) {
        this.numberRepositoryInt = numberRepositoryInt;
        //this.getUserNumberHistoryByDetailsUseCase = getUserNumberHistoryByDetailsUseCase;
    }

    public UserNumberHistory execute(UserNumberHistory userNumberHistory) {
//        UserNumberHistory oldUserNumber = getUserNumberHistoryByDetailsUseCase.execute(userNumberHistory);
//        if (oldUserNumber == null) {
//
//        } else {
//
//        }
        return numberRepositoryInt.saveUserNumberHistory(userNumberHistory);
    }

}
