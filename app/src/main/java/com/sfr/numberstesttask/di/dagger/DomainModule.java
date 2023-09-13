package com.sfr.numberstesttask.di.dagger;

import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.data.local.sql.service.number.UserNumberHistoryLocalServiceInt;
import com.sfr.data.network.service.number.NumberRemoteServiceInt;
import com.sfr.data.repository_impl.NumberRepositoryIntImpl;
import com.sfr.domain.repository.NumberRepositoryInt;
import com.sfr.domain.use_case.number.DeleteUserNumberHistoryUseCaseByDetails;
import com.sfr.domain.use_case.number.GetNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetRandomNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByDetailsUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByPrimaryKeyUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryUseCase;
import com.sfr.domain.use_case.number.SaveUserNumberHistoryUseCase;
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

    @Provides
    GetNumberInformationUseCase provideGetNumberInformationUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new GetNumberInformationUseCase(numberRepositoryInt);
    }

    @Provides
    GetRandomNumberInformationUseCase provideGetRandomNumberInformationUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new GetRandomNumberInformationUseCase(
                numberRepositoryInt
        );
    }

    @Provides
    GetUserNumberHistoryByPrimaryKeyUseCase provideGetUserNumberHistoryByPrimaryKeyUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new GetUserNumberHistoryByPrimaryKeyUseCase(
                numberRepositoryInt
        );
    }

    @Provides
    GetUserNumbersHistoryUseCase provideGetUserNumbersHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new GetUserNumbersHistoryUseCase(
                numberRepositoryInt
        );
    }

    @Provides
    GetUserNumberHistoryByDetailsUseCase provideGetUserNumberHistoryByDetailsUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new GetUserNumberHistoryByDetailsUseCase(
                numberRepositoryInt
        );
    }

    @Provides
    DeleteUserNumberHistoryUseCaseByDetails provideDeleteUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt) {
        return new DeleteUserNumberHistoryUseCaseByDetails(
                numberRepositoryInt
        );
    }

    @Provides
    SaveUserNumberHistoryUseCase provideSaveUserNumberHistoryUseCase(NumberRepositoryInt numberRepositoryInt, GetUserNumberHistoryByDetailsUseCase getUserNumberHistoryByDetailsUseCase, DeleteUserNumberHistoryUseCaseByDetails deleteUserNumberHistoryUseCaseByDetails) {
        return new SaveUserNumberHistoryUseCase(
                numberRepositoryInt, getUserNumberHistoryByDetailsUseCase, deleteUserNumberHistoryUseCaseByDetails
        );
    }

}
