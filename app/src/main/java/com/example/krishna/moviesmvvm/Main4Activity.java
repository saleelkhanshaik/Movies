package com.example.krishna.moviesmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.krishna.R;
import com.example.krishna.adapters.MoviesListAdapter;
import com.example.krishna.model.SearchItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main4Activity extends AppCompatActivity implements MoviesListAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    TextView textView ;
    ProgressBar progressBar;
    EditText editText;
    MoviewMVVM moviewMVVM;
    private  MoviesListAdapter n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        moviewMVVM =new ViewModelProvider(this).get(MoviewMVVM.class);
        recyclerView  = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.textView2);
        progressBar = findViewById(R.id.progressBar2);
        editText = findViewById(R.id.editText55);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>=3){
                    moviewMVVM.APICall(editable.toString());
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    assert imm != null;
                    imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
                }
            }
        });
//        APICall();
        LiveData<List<SearchItem>> moviesList = moviewMVVM.getSearchItemMutableLiveData();
        moviesList.observe(this, new Observer<List<SearchItem>>() {
            @Override
            public void onChanged(List<SearchItem> searchItems) {
                    setAdapter(searchItems);
            }
        });
    }

    private void setAdapter(List<SearchItem> body) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         n =new  MoviesListAdapter(this, body,
                this);
        recyclerView.setAdapter(n);
        setVisibility(2);
    }

    private void setVisibility(int pos){
        switch (pos){
            case 0:
                recyclerView.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                break;
            case 1:
                recyclerView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                break;
            case 2:
                progressBar.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onItemClicked(@NotNull SearchItem searchItem) {

    }
}
