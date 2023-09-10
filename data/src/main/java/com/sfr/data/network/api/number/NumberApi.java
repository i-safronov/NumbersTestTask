package com.sfr.data.network.api.number;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumberApi {

    @GET("{number}")
    Call<String> getNumberInformation(@Path("number") String number);

    @GET
    Call<String> getRandomNumberInformation();

    String MAIN_URL = "http://numbersapi.com/";
    String URL_TO_GET_RANDOM_NUMBER = "random/math";

}
