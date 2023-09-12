package com.sfr.numberstesttask.presentation.screen.fragment.main_page;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.numberstesttask.R;
import com.sfr.numberstesttask.app.App;
import com.sfr.numberstesttask.databinding.FragmentMainPageBinding;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.rcv.RcvUserNumbersHistory;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.rcv.RcvUserNumbersHistoryInt;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModel;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModelProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class FragmentMainPage extends Fragment implements RcvUserNumbersHistoryInt {

    private final String className = FragmentMainPage.this.getClass().getName();
    private final String TAG = "sfrLog";
    private FragmentMainPageBinding binding;
    private RcvUserNumbersHistory rcvUserNumbersHistory = new RcvUserNumbersHistory(FragmentMainPage.this);

    @Inject
    public FragmentMainPageViewModelProvider fragmentMainPageViewModelProvider;
    private FragmentMainPageViewModel fragmentMainPageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        try {
            setupViewModel();
            setupView();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
            Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
        }
        return binding.getRoot();
    }

    private void setupViewModel() {
        ((App) requireContext().getApplicationContext()).getAppComponent().inject(FragmentMainPage.this);
        fragmentMainPageViewModel = fragmentMainPageViewModelProvider.create(FragmentMainPageViewModel.class);
    }

    private void setupView() {
        binding.edtvNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        binding.rcvUserNumbersHistory.setAdapter(rcvUserNumbersHistory);
        binding.rcvUserNumbersHistory.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            observeUserNumbersHistory();
            edtvNumberOnTextChangeListener();
            btnGetNumberInfoOnClickListener();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
        }
    }

    private void observeUserNumbersHistory() {
        fragmentMainPageViewModel.getUserNumbersHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<List<UserNumberHistory>>() {
                    @Override
                    public void onNext(List<UserNumberHistory> list) {
                        rcvUserNumbersHistory.submitList(list);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "On error: " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "On complete");
                    }
                });
    }

    private void btnGetNumberInfoOnClickListener() {
        binding.btnGetNumberInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNumber = binding.edtvNumber.getText().toString().trim();
                if (userNumber.isEmpty()) {
                    binding.edtvNumber.setError(getString(R.string.write_something));
                } else {
                    Single<NumberInformationModel> numberInformation = fragmentMainPageViewModel.getNumberInformation(new NumberModel(userNumber));
                    numberInformation
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<NumberInformationModel>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onSuccess(@NonNull NumberInformationModel numberInformationModel) {
                                    Toast.makeText(requireContext(), "Result is: " + numberInformationModel.getNumberInfo(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {
                                    Log.d(TAG, "On error: " + e);
                                }
                            });
                }
            }
        });
    }

    private void edtvNumberOnTextChangeListener() {
        binding.edtvNumber.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    binding.btnGetNumberInfo.setEnabled(false);
                } else {
                    binding.btnGetNumberInfo.setEnabled(true);
                }
            }

        });
    }

    @Override
    public void onHistoryClick(UserNumberHistory userNumberHistory) {

    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

}