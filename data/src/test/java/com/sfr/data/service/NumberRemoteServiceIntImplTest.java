package com.sfr.data.service;

import com.sfr.data.network.api.number.NumberApi;
import com.sfr.data.network.service.number.NumberRemoteServiceIntImpl;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import retrofit2.Call;
import retrofit2.Callback;

public class NumberRemoteServiceIntImplTest {

    @Test
    void getNumberInformationTest() {
        Call<String> call = Mockito.mock(Call.class);

        NumberApi numberApi = Mockito.mock(NumberApi.class);
        Mockito.when(numberApi.getNumberInformation(Mockito.any())).thenReturn(call);
        NumberRemoteServiceIntImpl numberRemoteServiceInt = new NumberRemoteServiceIntImpl(numberApi);
    }

}
