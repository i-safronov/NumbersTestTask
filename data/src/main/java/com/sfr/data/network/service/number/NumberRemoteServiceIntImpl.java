package com.sfr.data.network.service.number;

import com.sfr.data.exception.DataException;
import com.sfr.data.network.api.number.NumberApi;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.result.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NumberRemoteServiceIntImpl implements NumberRemoteServiceInt {

    private NumberApi numberApi;

    public NumberRemoteServiceIntImpl(
            NumberApi numberApi
    ) {
        this.numberApi = numberApi;
    }

    @Override
    public void getNumberInformation(NumberModel numberModel, Result<NumberInformationModel> result) {
        try {
            Call<String> request = numberApi.getNumberInformation(numberModel.getNumber());
            request.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        result.onSuccess(
                                new NumberInformationModel(response.body())
                        );
                    } else {
                        throw new DataException("Response from the server isn't successful: " + response.code(), new IllegalStateException());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    throw new DataException("On failure from server: " + t.getMessage(), t);
                }
            });
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

    @Override
    public void getRandomNumberInformation(Result<NumberInformationModel> result) {
        try {
            Call<String> request = numberApi.getRandomNumberInformation();
            request.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        result.onSuccess(
                                new NumberInformationModel(response.body())
                        );
                    } else {
                        throw new DataException("Response from the server isn't successful: " + response.code(), new IllegalStateException());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    throw new DataException("On failure from server: " + t.getMessage(), t);
                }
            });
        } catch (Exception e) {
            throw new DataException("Data exception: " + e.getMessage(), e);
        }
    }

}
