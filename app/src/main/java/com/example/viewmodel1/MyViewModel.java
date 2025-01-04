package com.example.viewmodel1;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<String> TextTimer = new MutableLiveData<>();
    CountDownTimer timer;
    private boolean isTimerRunning = false;

    public LiveData<String> getTextTimer() {
        return TextTimer;
    }

    public void startTimer() {
        if (!isTimerRunning) {
            isTimerRunning = true;
            timer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    TextTimer.setValue("Timer: " + millisUntilFinished / 1000 + "секунд");

                }

                @Override
                public void onFinish() {
                    TextTimer.setValue("Time over!");
                }
            };
            timer.start();
        }

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (timer != null) {
            timer.cancel();
        }
    }
}
