package com.kuldeep.javamvvmapp.viewmodel;

public interface LoginListner {
    void onStart(String message);
    void onSuccess(String message);
    void onFailure(String message);

    void gotoDashBoard();
}
