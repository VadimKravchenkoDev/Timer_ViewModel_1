package com.example.timerviewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TimerViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public TimerViewModelFactory(Context context) {
        this.context = context.getApplicationContext();
    }
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass){
        return (T) new MainViewModel(context);
    }
}

