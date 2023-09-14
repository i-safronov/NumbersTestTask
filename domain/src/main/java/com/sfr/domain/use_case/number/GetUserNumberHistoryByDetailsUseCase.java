package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.Optional;

import io.reactivex.rxjava3.annotations.Nullable;

public class GetUserNumberHistoryByDetailsUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumberHistoryByDetailsUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    @Nullable Optional<UserNumberHistory> execute(UserNumberHistory userNumberHistory) {
        return numberRepositoryInt.getUserNumberHistoryByDetails(userNumberHistory.getNumberModel().getNumber());
    }

}
