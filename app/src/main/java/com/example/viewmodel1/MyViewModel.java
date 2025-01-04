package com.example.viewmodel1;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<String> TextTimer = new MutableLiveData<>();
    CountDownTimer timer;

    public LiveData<String> getTextTimer(){
        return TextTimer;
    }
    public void startTimer(){
        timer = new CountDownTimer(10000, 1000){
        @Override
        public void onTick(long millisUntilFinished) {
            TextTimer.setValue("Timer: "+ millisUntilFinished/1000+ "секунд");

        }
        @Override
        public void onFinish() {
            TextTimer.setValue("Time over!");
            //timerText.setText("Time over!");
        }
        };
        timer.start();
    }
}
