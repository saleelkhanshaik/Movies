package com.example.krishna.mvvm.loginexample;

import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginModelExample extends ViewModel {
    public MutableLiveData<String> errorString = new MutableLiveData<>();

//    public MutableLiveData<String> getErrorMessage() {
//        if (errorString == null) {
//            errorString = new MutableLiveData<>();
//        }
//        return errorString;
//    }

    public void checkConditions(EditText editText, EditText editText2) {

        if (editText.getText().toString().isEmpty() && editText2.getText().toString().isEmpty()) {
            errorString.setValue("User Id and password should not be empty");
            return;
        }
        if (editText.getText().toString().isEmpty()) {
            errorString.setValue("User Id should not be empty");
            return;
        }
        if (editText2.getText().toString().isEmpty()) {
            errorString.setValue("Password should not be empty");
            return;
        }
        if (!editText.getText().toString().equalsIgnoreCase("saleel")
                || !editText2.getText().toString().equalsIgnoreCase("12345")) {
            errorString.setValue("Incorrect Credentails..!");
            return;
        }
        errorString.setValue("....CONGRATS....");
    }
}
