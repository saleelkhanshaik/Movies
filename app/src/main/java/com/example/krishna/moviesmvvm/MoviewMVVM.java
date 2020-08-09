package com.example.krishna.moviesmvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.krishna.model.MoviesApiService;
import com.example.krishna.model.Response;
import com.example.krishna.model.SearchItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MoviewMVVM extends ViewModel {
    private MoviesApiService apiSerivce ;
    public MutableLiveData<String> noData=new MutableLiveData<String>();
    private MutableLiveData<List<SearchItem>> searchItemMutableLiveData;
    public MutableLiveData<List<SearchItem>> getSearchItemMutableLiveData(){
        if(searchItemMutableLiveData == null){
            searchItemMutableLiveData = new MutableLiveData<java.util.List<SearchItem>>();
        }
        return searchItemMutableLiveData;
    }
    public void APICall(String filter){
        apiSerivce = new MoviesApiService();
        Call<Response> call =  apiSerivce.movieList(1,filter);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                setAdapter(response.body());
                searchItemMutableLiveData.setValue(response.body().getSearch());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                noData.setValue("No Data Available...");
//                setVisibility(1);
            }
        });
    }

}
