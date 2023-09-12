package com.sfr.numberstesttask.di.dagger;

import android.content.Context;
import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sfr.data.local.sql.dao.db.UserNumberHistoryDB;
import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.data.local.sql.dao.number.UserNumberHistoryDao;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceInt;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceIntImpl;
import com.sfr.data.network.api.number.NumberApi;
import com.sfr.data.network.service.number.NumberRemoteServiceInt;
import com.sfr.data.network.service.number.NumberRemoteServiceIntImpl;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private static final String USER_NUMBER_HISTORY_DB_NAME = "sfrAppUserNumberHistory.db";

    @Provides
    UserNumberHistoryDB provideUserNumberHistoryDB(Context context) {
        return Room.databaseBuilder(context, UserNumberHistoryDB.class, USER_NUMBER_HISTORY_DB_NAME).build();
    }

    @Provides
    UserNumberHistoryDao provideUserNumberHistoryDao(UserNumberHistoryDB userNumberHistoryDB) {
        return userNumberHistoryDB.getUserNumberHistoryDao();
    }

    @Provides
    UserNumberHistoryEntityConverter provideUserNumberHistoryEntityConverter() {
        return new UserNumberHistoryEntityConverter();
    }

    @Provides
    UserNumberHistoryLocalServiceInt provideUserNumberHistoryLocalServiceInt(UserNumberHistoryDao userNumberHistoryDao) {
        return new UserNumberHistoryLocalServiceIntImpl(
                userNumberHistoryDao
        );
    }

    @Provides
    NumberApi provideNumberApi() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit builder = new Retrofit.Builder().baseUrl(NumberApi.MAIN_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();
        return builder.create(NumberApi.class);
    }

    @Provides
    NumberRemoteServiceInt provideNumberRemoteServiceInt(NumberApi numberApi) {
        return new NumberRemoteServiceIntImpl(numberApi);
    }

}
