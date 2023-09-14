package com.sfr.numberstesttask.di.dagger;

import android.content.Context;

import com.sfr.domain.use_case.number.GetNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetRandomNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByPrimaryKeyUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryAsListUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryUseCase;
import com.sfr.domain.use_case.number.SaveUserNumberHistoryUseCase;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModelProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    FragmentMainPageViewModelProvider provideFragmentMainPageViewModelProvider(
            GetNumberInformationUseCase getNumberInformationUseCase,
            GetRandomNumberInformationUseCase getRandomNumberInformationUseCase,
            GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase,
            GetUserNumbersHistoryAsListUseCase getUserNumbersHistoryAsListUseCase,
            SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase
    ) {
        return new FragmentMainPageViewModelProvider(
                getNumberInformationUseCase,
                getRandomNumberInformationUseCase,
                getUserNumberHistoryByPrimaryKeyUseCase,
                getUserNumbersHistoryAsListUseCase,
                saveUserNumberHistoryUseCase
        );
    }

}
