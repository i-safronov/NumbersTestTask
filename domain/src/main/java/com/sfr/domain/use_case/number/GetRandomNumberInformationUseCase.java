package com.sfr.domain.use_case.number;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.repository.NumberRepositoryInt;

public class GetRandomNumberInformationUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetRandomNumberInformationUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    NumberInformationModel execute() {
        return numberRepositoryInt.getRandomNumberInformation();
    }

}
