package com.sfr.data.network.service.number;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.result.Result;

public interface NumberRemoteServiceInt {

    void getNumberInformation(NumberModel numberModel, Result<NumberInformationModel> result);
    void getRandomNumberInformation(Result<NumberInformationModel> result);

}
