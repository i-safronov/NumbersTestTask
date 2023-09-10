package com.sfr.data.repository_impl;

import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceInt;
import com.sfr.data.network.api.number.NumberApi;
import com.sfr.data.network.service.number.NumberRemoteServiceIntImpl;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.repository.NumberRepositoryInt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class NumberRepositoryIntImplTestRemote {

    private NumberRepositoryInt numberRepositoryInt;
    private String resultFromServer = "Result from server";

    @Before
    public void init() throws IOException {
        UserNumberHistoryEntityConverter userNumberHistoryEntityConverter = new UserNumberHistoryEntityConverter();
        Call call = Mockito.mock(Call.class);
        UserNumberHistoryLocalServiceInt userNumberHistoryLocalServiceInt = Mockito.mock(UserNumberHistoryLocalServiceInt.class);
        Mockito.when(call.execute()).thenReturn(Response.success(resultFromServer));
        NumberApi numberApi = Mockito.mock(NumberApi.class);
        Mockito.when(numberApi.getNumberInformation(Mockito.any())).thenReturn(call);
        Mockito.when(numberApi.getRandomNumberInformation()).thenReturn(call);
        NumberRemoteServiceIntImpl numberRemoteServiceInt = new NumberRemoteServiceIntImpl(numberApi);
        numberRepositoryInt = new NumberRepositoryIntImpl(
                userNumberHistoryLocalServiceInt, userNumberHistoryEntityConverter, numberRemoteServiceInt
        );
    }

    @Test
    public void getNumberInformationTest() {
        NumberInformationModel numberInformation = numberRepositoryInt.getNumberInformation(new NumberModel("1"));
        System.out.println("\n\nResult is: " + numberInformation.getNumberInfo());
        Assert.assertEquals(resultFromServer, numberInformation.getNumberInfo());
    }

    @Test
    public void getRandomNumberInformationTest() {
        NumberInformationModel numberInformation = numberRepositoryInt.getRandomNumberInformation();
        System.out.println("\n\nResult is: " + numberInformation.getNumberInfo());
        Assert.assertEquals(numberInformation.getNumberInfo(), numberInformation.getNumberInfo());
    }

}
