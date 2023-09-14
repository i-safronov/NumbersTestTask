package com.sfr.numberstesttask.presentation.screen.fragment.main_page;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.domain.model.UserNumberHistory;
import com.sfr.numberstesttask.R;
import com.sfr.numberstesttask.app.App;
import com.sfr.numberstesttask.databinding.AlertDialogNotificationBinding;
import com.sfr.numberstesttask.databinding.FragmentMainPageBinding;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.rcv.RcvUserNumbersHistory;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.rcv.RcvUserNumbersHistoryInt;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModel;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModelProvider;
import com.sfr.numberstesttask.presentation.screen.fragment.number_details.FragmentNumberDetails;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FragmentMainPage extends Fragment implements RcvUserNumbersHistoryInt {

    private final String className = FragmentMainPage.this.getClass().getName();
    private final String TAG = "sfrLog";
    private AlertDialog loadingDataAlertDialog;
    private FragmentMainPageBinding binding;
    private RcvUserNumbersHistory rcvUserNumbersHistory = new RcvUserNumbersHistory(FragmentMainPage.this);

    @Inject
    public FragmentMainPageViewModelProvider fragmentMainPageViewModelProvider;
    private FragmentMainPageViewModel fragmentMainPageViewModel;

    @Inject
    public UserNumberHistoryEntityConverter userNumberHistoryEntityConverter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        try {
            setupLoadingDataAlertDialog();
            showDataIsLoading();
            init();
            setupViewModel();
            setupView();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
            Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
        }
        return binding.getRoot();
    }

    private void setupLoadingDataAlertDialog() {
        loadingDataAlertDialog = new AlertDialog.Builder(requireContext()).create();
        AlertDialogNotificationBinding alertDialogView = AlertDialogNotificationBinding.inflate(getLayoutInflater());
        alertDialogView.tvTitle.setText(getString(R.string.wait_data_is_loading));
        loadingDataAlertDialog.setView(alertDialogView.getRoot());
        loadingDataAlertDialog.setCancelable(false);
    }

    private void showDataIsLoading() {
        loadingDataAlertDialog.show();
    }

    private void showDataLoaded() {
        loadingDataAlertDialog.dismiss();
    }

    private void init() {
        ((App) requireContext().getApplicationContext()).getAppComponent().inject(FragmentMainPage.this);
    }

    private void setupViewModel() {
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
            loadUserNumbersHistory();
            edtvNumberOnTextChangeListener();
            btnGetNumberInfoOnClickListener();
            btnGetRandomNumberInfoListener();
            showDataLoaded();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
        }
    }

    private void btnGetRandomNumberInfoListener() {
        binding.btnGetRandomNumberInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataIsLoading();
                fragmentMainPageViewModel.getRandomNumberInformation()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new SingleObserver<NumberInformationModel>() {
                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                                Log.d(TAG, "onSubscribe");
                            }

                            @Override
                            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull NumberInformationModel numberInformationModel) {
                                saveUserNumberHistory(numberInformationModel);
                                loadUserNumbersHistory();
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                Log.e(TAG, "onError: " + e.getMessage());
                            }
                        });
            }
        });
    }

    private void loadUserNumbersHistory() {
        fragmentMainPageViewModel.getUserNumbersHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<UserNumberHistory>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<UserNumberHistory> list) {
                        Collections.reverse(list);
                        rcvUserNumbersHistory.submitList(list);
                        showDataLoaded();
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
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
                    showDataIsLoading();
                    Single<NumberInformationModel> numberInformation = fragmentMainPageViewModel.getNumberInformation(new NumberModel(userNumber));
                    numberInformation
                            .subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.io())
                            .subscribe(new SingleObserver<NumberInformationModel>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {
                                    Log.d(TAG, "onSubscribe: single");
                                }

                                @Override
                                public void onSuccess(@NonNull NumberInformationModel numberInformationModel) {
                                    try {
                                        saveUserNumberHistory(numberInformationModel);
                                        loadUserNumbersHistory();
                                    } catch (Exception e) {
                                        Log.e(TAG, "onError: " + e.getMessage());
                                    }
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

    private void saveUserNumberHistory(NumberInformationModel numberInformationModel) {
        fragmentMainPageViewModel.saveUserNumberHistory(
                new UserNumberHistory(
                        new NumberModel(numberInformationModel.getNumber()),
                        numberInformationModel
                )
        );
    }

    @Override
    public void onHistoryClick(UserNumberHistory userNumberHistory) {
        goToTheFragmentNumberDetails(userNumberHistory);
    }

    private void goToTheFragmentNumberDetails(UserNumberHistory userNumberHistory) {
        NumberInformationModel numberInformationModel = userNumberHistoryEntityConverter.convertUserNumberHistoryToNumberInformationModel(userNumberHistory);
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentNumberDetails.CURRENT_NUMBER_INFORMATION_MODEL, numberInformationModel);
        NavHostFragment.findNavController(FragmentMainPage.this).navigate(
                R.id.action_fragmentMainPage_to_fragmentNumberDetails,
                bundle
        );
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

}