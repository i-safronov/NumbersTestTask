package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.List;

public class GetUserNumbersHistoryAsListUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumbersHistoryAsListUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    List<UserNumberHistory> execute() {
        return numberRepositoryInt.getUserNumbersHistoryAsList();
    }

}
