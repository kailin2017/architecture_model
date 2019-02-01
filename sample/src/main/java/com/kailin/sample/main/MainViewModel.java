package com.kailin.sample.main;

import android.os.Handler;

import com.kailin.sample.data.User;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public final MutableLiveData<User> user = new MutableLiveData<>();

    public void newUser(){
        Handler handler = new Handler();
        handler.postDelayed(() -> user.postValue(new User("Tiger")), 2000);
    }
}
