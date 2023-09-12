package com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model;

import androidx.lifecycle.ViewModel;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.use_case.number.GetNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetRandomNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByPrimaryKeyUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryUseCase;
import com.sfr.domain.use_case.number.SaveUserNumberHistoryUseCase;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;

public class FragmentMainPageViewModel extends ViewModel {

    private GetNumberInformationUseCase getNumberInformationUseCase;
    private GetRandomNumberInformationUseCase getRandomNumberInformationUseCase;
    private GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase;
    private GetUserNumbersHistoryUseCase getUserNumbersHistoryUseCase;
    private SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase;

    public FragmentMainPageViewModel(
            GetNumberInformationUseCase getNumberInformationUseCase,
            GetRandomNumberInformationUseCase getRandomNumberInformationUseCase,
            GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase,
            GetUserNumbersHistoryUseCase getUserNumbersHistoryUseCase,
            SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase
    ) {
        super();
        this.getNumberInformationUseCase = getNumberInformationUseCase;
        this.getRandomNumberInformationUseCase = getRandomNumberInformationUseCase;
        this.getUserNumberHistoryByPrimaryKeyUseCase = getUserNumberHistoryByPrimaryKeyUseCase;
        this.getUserNumbersHistoryUseCase = getUserNumbersHistoryUseCase;
        this.saveUserNumberHistoryUseCase = saveUserNumberHistoryUseCase;
    }

    Single<NumberInformationModel> getNumberInformation(NumberModel numberModel) {
        return Single.create(new SingleOnSubscribe<NumberInformationModel>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<NumberInformationModel> emitter) throws Throwable {
                emitter.onSuccess(getNumberInformationUseCase.execute(numberModel));
            }
        });
    }

}
