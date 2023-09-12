package com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.sfr.domain.use_case.number.GetNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetRandomNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByPrimaryKeyUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryUseCase;
import com.sfr.domain.use_case.number.SaveUserNumberHistoryUseCase;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.FragmentMainPage;

public class FragmentMainPageViewModelProvider implements ViewModelProvider.Factory {

    private GetNumberInformationUseCase getNumberInformationUseCase;
    private GetRandomNumberInformationUseCase getRandomNumberInformationUseCase;
    private GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase;
    private GetUserNumbersHistoryUseCase getUserNumbersHistoryUseCase;
    private SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase;

    public FragmentMainPageViewModelProvider(
            GetNumberInformationUseCase getNumberInformationUseCase,
            GetRandomNumberInformationUseCase getRandomNumberInformationUseCase,
            GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase,
            GetUserNumbersHistoryUseCase getUserNumbersHistoryUseCase,
            SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase)
    {
        this.getNumberInformationUseCase = getNumberInformationUseCase;
        this.getRandomNumberInformationUseCase = getRandomNumberInformationUseCase;
        this.getUserNumberHistoryByPrimaryKeyUseCase = getUserNumberHistoryByPrimaryKeyUseCase;
        this.getUserNumbersHistoryUseCase = getUserNumbersHistoryUseCase;
        this.saveUserNumberHistoryUseCase = saveUserNumberHistoryUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FragmentMainPageViewModel(
                getNumberInformationUseCase,
                getRandomNumberInformationUseCase,
                getUserNumberHistoryByPrimaryKeyUseCase,
                getUserNumbersHistoryUseCase,
                saveUserNumberHistoryUseCase
        );
    }

}
