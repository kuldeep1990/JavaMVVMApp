package com.kuldeep.javamvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.kuldeep.javamvvmapp.R;
import com.kuldeep.javamvvmapp.databinding.ActivityLoginBinding;
import com.kuldeep.javamvvmapp.model.LoginModel;
import com.kuldeep.javamvvmapp.utils.Utility;
import com.kuldeep.javamvvmapp.viewmodel.LoginListner;
import com.kuldeep.javamvvmapp.viewmodel.LoginViewModel;
import com.kuldeep.javamvvmapp.viewmodelfactory.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity implements LoginListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
//        LoginViewModel model = ViewModelProviders.of(this,new LoginViewModelFactory(this,new LoginModel())).get(LoginViewModel.class);
//        if we have viewModel factory than use below method
        LoginViewModel model = new ViewModelProvider(this,new LoginViewModelFactory(this,new LoginModel())).get(LoginViewModel.class);
//        if we do not have factory than use below method
//        LoginViewModel model = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginModel(model);
        model.listner= this;
    }

    @Override
    public void onStart(String message) {
        Utility.Toast(LoginActivity.this,message);
    }

    @Override
    public void onSuccess(String message) {
        Utility.Toast(LoginActivity.this,message);
    }

    @Override
    public void onFailure(String message) {
        Utility.Toast(LoginActivity.this,message);
    }

    @Override
    public void gotoDashBoard() {
        Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}