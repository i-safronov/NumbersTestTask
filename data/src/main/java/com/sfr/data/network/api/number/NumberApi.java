package com.sfr.data.network.api.number;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumberApi {

    @GET("{number}")
    Call<String> getNumberInformation(@Path("number") String number);

    @GET
    Call<String> getRandomNumberInformation();

    public static String MAIN_URL = "http://numbersapi.com/";
    public static String URL_TO_GET_RANDOM_NUMBER = "random/math";

}
