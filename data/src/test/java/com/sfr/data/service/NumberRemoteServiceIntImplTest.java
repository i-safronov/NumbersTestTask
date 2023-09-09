package com.sfr.data.service;

import com.sfr.data.network.api.number.NumberApi;
import com.sfr.data.network.service.number.NumberRemoteServiceIntImpl;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class NumberRemoteServiceIntImplTest {

    @Test
    public void getNumberInformationTest_expectedResultFromServerWithoutException() throws IOException {
        String resultFromServer = "Result from server";
        Call call = Mockito.mock(Call.class);
        Mockito.when(call.execute()).thenReturn(Response.success(resultFromServer));

        NumberApi numberApi = Mockito.mock(NumberApi.class);
        Mockito.when(numberApi.getNumberInformation(Mockito.any())).thenReturn(call);
        NumberRemoteServiceIntImpl numberRemoteServiceInt = new NumberRemoteServiceIntImpl(numberApi);

        NumberInformationModel numberInformation = numberRemoteServiceInt.getNumberInformation(new NumberModel("1"));

        System.out.println("\n\nResult is: " + numberInformation.getNumberInfo());
        Assert.assertEquals(resultFromServer, numberInformation.getNumberInfo());
    }

    @Test
    public void getRandomNumberInformation_expectedRandomNumberFromServerWithoutException() throws IOException {
        String randomNumber = "8";
        Call call = Mockito.mock(Call.class);
        Mockito.when(call.execute()).thenReturn(Response.success(randomNumber));

        NumberApi numberApi = Mockito.mock(NumberApi.class);
        Mockito.when(numberApi.getRandomNumberInformation()).thenReturn(call);
        NumberRemoteServiceIntImpl numberRemoteServiceInt = new NumberRemoteServiceIntImpl(numberApi);

        NumberInformationModel numberInformation = numberRemoteServiceInt.getRandomNumberInformation();

        System.out.println("\n\nResult is: " + numberInformation.getNumberInfo());
        Assert.assertEquals(numberInformation.getNumberInfo(), numberInformation.getNumberInfo());
    }

}
