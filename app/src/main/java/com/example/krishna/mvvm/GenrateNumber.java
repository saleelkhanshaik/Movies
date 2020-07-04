package com.example.krishna.mvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class GenrateNumber extends ViewModel {
    public    MutableLiveData<String> num ;
    public MutableLiveData<String> genrateNumber(){
        if(num == null){
            num = new MutableLiveData<>();
//            createNumber();
        }
        return  num;
    }

    public void createNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
//        num = randomNumber+"";
        num.setValue("RANDOM ____ "+randomNumber);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("VIEWMODEL", "onCleared: ");
    }
}
