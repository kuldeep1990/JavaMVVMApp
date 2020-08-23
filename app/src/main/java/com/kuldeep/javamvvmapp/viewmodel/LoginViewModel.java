package com.kuldeep.javamvvmapp.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kuldeep.javamvvmapp.model.LoginModel;
import com.kuldeep.javamvvmapp.utils.Utility;

public class LoginViewModel extends ViewModel {

    public String email ;
    public String password ;
    public LoginModel model;
    private Context context;
    public LoginListner listner;

    public LoginViewModel(Context context, LoginModel model){
        this.context=context;
        this.model = model;

    }

    public void onLoginClick(View view) {
        model.setEmail(email);
        model.setPassword(password);
        if (model.getEmail() == null ){
            listner.onFailure("Please enter email");
        }else if (!Utility.isValidEmail(model.getEmail())){
            listner.onFailure("Please correct enter email");
        }
        else if (model.getPassword() == null){
            listner.onFailure("Please enter Password");
        }else if (!Utility.isValidPassword(model.getPassword())){
            listner.onFailure("Please correct enter Password");
        }else {
            listner.gotoDashBoard();
        }

    }


}
