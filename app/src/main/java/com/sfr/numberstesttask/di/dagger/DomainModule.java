package com.sfr.numberstesttask.di.dagger;

import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceInt;
import com.sfr.data.network.service.number.NumberRemoteServiceInt;
import com.sfr.data.repository_impl.NumberRepositoryIntImpl;
import com.sfr.domain.repository.NumberRepositoryInt;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    NumberRepositoryInt provideNumberRepositoryInt(
            UserNumberHistoryLocalServiceInt userNumberHistoryLocalServiceInt,
            UserNumberHistoryEntityConverter userNumberHistoryEntityConverter,
            NumberRemoteServiceInt numberRemoteServiceInt
    ) {
        return new NumberRepositoryIntImpl(
                userNumberHistoryLocalServiceInt,
                userNumberHistoryEntityConverter,
                numberRemoteServiceInt
        );
    }

}
