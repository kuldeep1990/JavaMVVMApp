package com.kuldeep.javamvvmapp.viewmodelfactory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kuldeep.javamvvmapp.model.LoginModel;
import com.kuldeep.javamvvmapp.view.LoginActivity;
import com.kuldeep.javamvvmapp.viewmodel.LoginViewModel;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginModel model;
    private Context context;
    public LoginViewModelFactory(LoginActivity loginActivity, LoginModel loginModel) {
        this.context=loginActivity;
        this.model=loginModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(context,model);
    }
}
