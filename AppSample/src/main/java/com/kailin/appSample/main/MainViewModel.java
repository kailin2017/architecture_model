package com.kailin.appSample.main;

import android.content.Context;
import android.os.Handler;

import com.kailin.appSample.data.User;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public final MutableLiveData<User> user = new MutableLiveData<>();

    public void newUser(Context context) {
        new Thread(()->user.postValue(new User("kailin", context))).start();
    }
}
