package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class GetUserNumbersHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumbersHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public Observable<List<UserNumberHistory>> execute() {
        return numberRepositoryInt.getUserNumbersHistory();
    }

}
