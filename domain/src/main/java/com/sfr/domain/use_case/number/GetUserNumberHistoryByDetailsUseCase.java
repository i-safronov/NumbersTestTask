package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class GetUserNumberHistoryByDetailsUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumberHistoryByDetailsUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    UserNumberHistory execute(UserNumberHistory userNumberHistory) {
        return numberRepositoryInt.getUserNumberHistoryByDetails(userNumberHistory.getNumberModel().getNumber(), userNumberHistory.getNumberInformationModel().getNumberInfo());
    }

}
