package com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model;

import androidx.lifecycle.ViewModel;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.domain.use_case.number.GetNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetRandomNumberInformationUseCase;
import com.sfr.domain.use_case.number.GetUserNumberHistoryByPrimaryKeyUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryAsListUseCase;
import com.sfr.domain.use_case.number.GetUserNumbersHistoryUseCase;
import com.sfr.domain.use_case.number.SaveUserNumberHistoryUseCase;

import java.util.List;
import java.util.Optional;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;

public class FragmentMainPageViewModel extends ViewModel {

    private GetNumberInformationUseCase getNumberInformationUseCase;
    private GetRandomNumberInformationUseCase getRandomNumberInformationUseCase;
    private GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase;
    private GetUserNumbersHistoryAsListUseCase getUserNumbersHistoryAsListUseCase;
    private SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase;

    public FragmentMainPageViewModel(
            GetNumberInformationUseCase getNumberInformationUseCase,
            GetRandomNumberInformationUseCase getRandomNumberInformationUseCase,
            GetUserNumberHistoryByPrimaryKeyUseCase getUserNumberHistoryByPrimaryKeyUseCase,
            GetUserNumbersHistoryAsListUseCase getUserNumbersHistoryAsListUseCase,
            SaveUserNumberHistoryUseCase saveUserNumberHistoryUseCase
    ) {
        super();
        this.getNumberInformationUseCase = getNumberInformationUseCase;
        this.getRandomNumberInformationUseCase = getRandomNumberInformationUseCase;
        this.getUserNumberHistoryByPrimaryKeyUseCase = getUserNumberHistoryByPrimaryKeyUseCase;
        this.getUserNumbersHistoryAsListUseCase = getUserNumbersHistoryAsListUseCase;
        this.saveUserNumberHistoryUseCase = saveUserNumberHistoryUseCase;
    }

    public Single<NumberInformationModel> getNumberInformation(NumberModel numberModel) {
        return Single.create(new SingleOnSubscribe<NumberInformationModel>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<NumberInformationModel> emitter) throws Throwable {
                emitter.onSuccess(getNumberInformationUseCase.execute(numberModel));
            }
        });
    }

    public Single<NumberInformationModel> getRandomNumberInformation() {
        return Single.create(new SingleOnSubscribe<NumberInformationModel>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<NumberInformationModel> emitter) throws Throwable {
                emitter.onSuccess(getRandomNumberInformationUseCase.execute());
            }
        });
    }

    public Single<List<UserNumberHistory>> getUserNumbersHistory() {
        return Single.create(new SingleOnSubscribe<List<UserNumberHistory>>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<List<UserNumberHistory>> emitter) throws Throwable {
                emitter.onSuccess(getUserNumbersHistoryAsListUseCase.execute());
            }
        });
    }

    public Optional<UserNumberHistory> saveUserNumberHistory(UserNumberHistory userNumberHistory) {
        return saveUserNumberHistoryUseCase.execute(userNumberHistory);
    }

}
