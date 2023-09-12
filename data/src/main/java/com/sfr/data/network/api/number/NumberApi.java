package com.sfr.data.network.api.number;

import com.sfr.data.network.api.number.model.NumberInformationModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface NumberApi {

    @Headers({"Content-type: application/json"})
    @GET("{number}")
    Call<NumberInformationModelResponse> getNumberInformation(@Path("number") String number);

    @Headers({"Content-type: application/json"})
    @GET(URL_TO_GET_RANDOM_NUMBER)
    Call<NumberInformationModelResponse> getRandomNumberInformation();

    String MAIN_URL = "http://numbersapi.com/";
    String URL_TO_GET_RANDOM_NUMBER = "random/math";

}
