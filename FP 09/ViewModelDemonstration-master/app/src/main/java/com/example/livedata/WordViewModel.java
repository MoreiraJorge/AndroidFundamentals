package com.example.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WordViewModel extends ViewModel {

    private MutableLiveData<String> word;

    public WordViewModel(){
        word = new MutableLiveData<>();
    }

    public void setWord(String arg){
        this.word.setValue(arg);
    }

    public LiveData<String> getWord(){
        return this.word;
    }
}
