package com.example.timerviewmodel;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> TimerLiveData = new MutableLiveData<>();
    private final Context context;
    private CountDownTimer timer ;
    private boolean startTimer = false;

    public MainViewModel(Context context) {
        this.context = context.getApplicationContext();
    }

    public LiveData<String> getTimerLiveData(){
        return TimerLiveData;
    }

    public void startTimer (){
        if(!startTimer){
            startTimer = true;
            timer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    TimerLiveData.setValue(millisUntilFinished/1000+"");
                }
                @Override
                public void onFinish() {
                    Toast.makeText(context,"Time's over",Toast.LENGTH_LONG).show();
                }
            };
            timer.start();
        }
    }
}
