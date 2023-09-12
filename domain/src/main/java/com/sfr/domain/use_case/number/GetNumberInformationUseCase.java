package com.sfr.domain.use_case.number;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.repository.NumberRepositoryInt;

public class GetNumberInformationUseCase {

    private NumberRepositoryInt numberRepositoryInt;

    public GetNumberInformationUseCase(NumberRepositoryInt numberRepositoryInt) {
        this.numberRepositoryInt = numberRepositoryInt;
    }

    public NumberInformationModel execute(NumberModel numberModel) {
        return numberRepositoryInt.getNumberInformation(numberModel);
    }

}
