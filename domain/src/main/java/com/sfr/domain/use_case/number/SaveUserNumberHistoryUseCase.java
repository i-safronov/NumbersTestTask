package com.sfr.domain.use_case.number;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.repository.NumberRepositoryInt;

public class SaveUserNumberHistoryUseCase {

    private NumberRepositoryInt numberRepositoryInt;
    private GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase;
    private DeleteUserNumberHistoryUseCaseByDetails deleteUserNumberHistoryUseCaseByDetails;

    public SaveUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt, GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase, DeleteUserNumberHistoryUseCaseByDetails deleteUserNumberHistoryUseCaseByDetails) {
        this.numberRepositoryInt = numberRepositoryInt;
        this.getUserNumberHistoryByDetailsUseCase = getUserNumberHistoryByDetailsUseCase;
        this.deleteUserNumberHistoryUseCaseByDetails = deleteUserNumberHistoryUseCaseByDetails;
    }

    public UserNumberHistory execute(UserNumberHistory userNumberHistory) {
        UserNumberHistory oldUserNumber = getUserNumberHistoryByDetailsUseCase.execute(userNumberHistory);
        if (oldUserNumber == null) {
            return numberRepositoryInt.saveUserNumberHistory(userNumberHistory);
        } else {
            deleteUserNumberHistoryUseCaseByDetails.execute(userNumberHistory);
            return numberRepositoryInt.saveUserNumberHistory(userNumberHistory);
        }
    }

}
