package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

import java.util.Optional;

public class SaveUserNumberHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;
    private GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase;
    private DeleteUserNumberHistoryUseCaseByDetails deleteUserNumberHistoryUseCaseByDetails;

    public SaveUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt, GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase, DeleteUserNumberHistoryUseCaseByDetails deleteUserNumberHistoryUseCaseByDetails) {
        this.numberRepositoryInt = numberRepositoryInt;
        this.getUserNumberHistoryByDetailsUseCase = getUserNumberHistoryByDetailsUseCase;
        this.deleteUserNumberHistoryUseCaseByDetails = deleteUserNumberHistoryUseCaseByDetails;
    }

    public Optional<UserNumberHistory> execute(UserNumberHistory userNumberHistory) {
        Optional<UserNumberHistory> oldUserNumber = getUserNumberHistoryByDetailsUseCase.execute(userNumberHistory);
        if (oldUserNumber.isPresent()) {
            deleteUserNumberHistoryUseCaseByDetails.execute(userNumberHistory);
        }
        return numberRepositoryInt.saveUserNumberHistory(userNumberHistory);
    }

}
