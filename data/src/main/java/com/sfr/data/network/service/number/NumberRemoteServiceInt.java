package com.sfr.data.network.service.number;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;

public interface NumberRemoteServiceInt {

    NumberInformationModel getNumberInformation(NumberModel numberModel);
    NumberInformationModel getRandomNumberInformation();

}
