package com.android.bidirectionaldatabindingsample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.android.bidirectionaldatabindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("双方向データバインディングサンプル");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewModel viewModel = new ViewModel();
        binding.setViewModel(viewModel);
    }
}
