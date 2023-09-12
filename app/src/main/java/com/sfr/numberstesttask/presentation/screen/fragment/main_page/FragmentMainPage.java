package com.sfr.numberstesttask.presentation.screen.fragment.main_page;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

import com.sfr.numberstesttask.R;
import com.sfr.numberstesttask.app.App;
import com.sfr.numberstesttask.databinding.FragmentMainPageBinding;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModel;
import com.sfr.numberstesttask.presentation.screen.fragment.main_page.view_model.FragmentMainPageViewModelProvider;

import javax.inject.Inject;

public class FragmentMainPage extends Fragment {

    private String className = FragmentMainPage.this.getClass().getName();
    private String TAG = "sfrLog";
    private FragmentMainPageBinding binding;

    private FragmentMainPageViewModel fragmentMainPageViewModel;
    @Inject
    public FragmentMainPageViewModelProvider fragmentMainPageViewModelProvider;

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
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            edtvNumberOnTextChangeListener();
            btnGetNumberInfoOnClickListener();
        } catch (Exception e) {
            Log.e(TAG, className + " , " + e.getMessage());
        }
    }

    private void btnGetNumberInfoOnClickListener() {
        binding.btnGetNumberInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

}