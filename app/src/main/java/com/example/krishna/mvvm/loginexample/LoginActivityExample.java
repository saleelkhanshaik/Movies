package com.example.krishna.mvvm.loginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.krishna.R;
import com.example.krishna.databinding.ALoginBinding;

public class LoginActivityExample extends AppCompatActivity {
    EditText editText,editText2;
    TextView textView2;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.a_login);
//        button2 = findViewById(R.id.button3);
//        editText = findViewById(R.id.editText3);
//        editText2 = findViewById(R.id.editText4);
//        textView2 = findViewById(R.id.textView3);
        ALoginBinding loginBinding = DataBindingUtil.setContentView(this,R.layout.a_login);

        LoginModelExample loginModelExample=new ViewModelProvider(this).get(LoginModelExample.class);
        loginBinding.setLogin(loginModelExample);
        loginBinding.setLifecycleOwner(this);
//        button2.setOnClickListener(view -> {
//            loginModelExample.checkConditions(editText,editText2);
//        });
//        LiveData<String> errortxt = loginModelExample.errorString;
//        errortxt.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                textView2.setText(s);
//            }
//        });
    }
}
