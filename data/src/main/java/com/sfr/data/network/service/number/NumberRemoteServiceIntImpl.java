package com.sfr.data.network.service.number;

import com.sfr.data.exception.DataException;
import com.sfr.data.network.api.number.NumberApi;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import retrofit2.Call;
import retrofit2.Response;

public class NumberRemoteServiceIntImpl implements NumberRemoteServiceInt {

    private NumberApi numberApi;

    public NumberRemoteServiceIntImpl(
            NumberApi numberApi
    ) {
        this.numberApi = numberApi;
    }

    @Override
    public NumberInformationModel getNumberInformation(NumberModel numberModel) {
        try {
            Call<String> request = numberApi.getNumberInformation(numberModel.getNumber());
            Response<String> response = request.execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return new NumberInformationModel(response.body());
            } else {
                throw new DataException("Response from the server isn't successful: " + response.code(), new IllegalStateException());
            }
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public NumberInformationModel getRandomNumberInformation() {
        try {
            Call<String> request = numberApi.getRandomNumberInformation();
            Response<String> response = request.execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return new NumberInformationModel(response.body());
            } else {
                throw new DataException("Response from the server isn't successful: " + response.code(), new IllegalStateException());
            }
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

}
