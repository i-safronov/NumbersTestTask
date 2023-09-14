package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class GetUserNumbersHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetUserNumbersHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public Observable<List<UserNumberHistory>> execute() {
        return numberRepositoryInt.getUserNumbersHistory().map(new Function<List<UserNumberHistory>, List<UserNumberHistory>>() {
            @Override
            public List<UserNumberHistory> apply(List<UserNumberHistory> list) throws Throwable {
                return list;
            }
        });
    }

}
