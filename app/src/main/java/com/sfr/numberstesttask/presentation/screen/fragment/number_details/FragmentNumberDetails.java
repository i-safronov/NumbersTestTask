package com.sfr.numberstesttask.presentation.screen.fragment.number_details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfr.data.local.sql.dao.db.model_converter.UserNumberHistoryEntityConverter;
import com.sfr.domain.model.NumberInformationModel;
import com.sfr.domain.model.NumberModel;
import com.sfr.numberstesttask.R;
import com.sfr.numberstesttask.app.App;
import com.sfr.numberstesttask.databinding.FragmentNumberDetailsBinding;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class FragmentNumberDetails extends Fragment {

    private String TAG = "sfrLog";
    private String className = FragmentNumberDetails.this.getClass().getName();
    private NumberInformationModel numberInformationModel;
    private FragmentNumberDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNumberDetailsBinding.inflate(inflater, container, false);
        try {
            init();
        } catch (Exception e) {
            Log.e(TAG, className + ", " + e.getMessage());
        }
        return binding.getRoot();
    }

    private void init() {
        numberInformationModel = getArgsAsNumberInformationModel();
    }

    private NumberInformationModel getArgsAsNumberInformationModel() {
        return (NumberInformationModel) requireArguments().getSerializable(CURRENT_NUMBER_INFORMATION_MODEL);
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            setupView();
        } catch (Exception e) {
            Log.e(TAG, className + ", " + e.getMessage());
        }
    }

    private void setupView() {
        binding.tvNumber.setText(numberInformationModel.getNumber());
        binding.tvNumberInfo.setText(numberInformationModel.getNumberInfo());
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    public static String CURRENT_NUMBER_INFORMATION_MODEL = "Current number information model";

}