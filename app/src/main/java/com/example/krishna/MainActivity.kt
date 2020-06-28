package com.example.krishna

import android.content.Context
import android.content.Intent
import android.net.*
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.krishna.adapters.MoviesListAdapter
import com.example.krishna.model.MoviesApiService
import com.example.krishna.model.Response
import com.example.krishna.model.SearchItem
import com.example.krishna.viewmodel.MainList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity(), MoviesListAdapter.OnItemClickListener {
    private val apiSerivce = MoviesApiService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainList = ViewModelProvider(this).get(MainList::class.java)

        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.length!! >= 3) {
                    if(checkNetworkConnection()){
                        callMoviesListAPI(p0.toString())
                        val imm: InputMethodManager =
                            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0)
                    }else{

                    }

                }
            }

        })
    }

    fun callMoviesListAPI(filter: String?) {
        setDatavisibiity(1)
        val call: Call<Response> = apiSerivce.movieList(1,filter)
        call.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                setDatavisibiity(2)
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                setDatavisibiity(3)
                setAdapter(response.body())
            }

        })
    }

    private fun setAdapter(body: Response?) {
        movieList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MoviesListAdapter(
                this@MainActivity,
                body?.search as MutableList<SearchItem>,this@MainActivity
            )
        }
    }

    fun setDatavisibiity(pos: Int) {

        when (pos) {
            1 -> {
                movieList.visibility = View.GONE
                noData.visibility = View.GONE
                loadingProgressbar.visibility = View.VISIBLE
            }
            2 -> {
                movieList.visibility = View.GONE
                noData.visibility = View.VISIBLE
                loadingProgressbar.visibility = View.GONE
            }
            3 -> {
                movieList.visibility = View.VISIBLE
                noData.visibility = View.GONE
                loadingProgressbar.visibility = View.GONE
            }
        }
    }


    override fun onItemClicked(searchItem: SearchItem) {
        val intent = Intent(this, DetailsFragment::class.java)
        intent.putExtra("movieName", searchItem.title)
        startActivity(intent)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun checkNetworkConnection():Boolean {
        val cm =
            this@MainActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder: NetworkRequest.Builder = NetworkRequest.Builder()
        var flag =false
        cm.registerNetworkCallback(
            builder.build(),
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    Log.i("MainActivity", "onAvailable!")
                    flag=true
                }

                override fun onLost(network: Network) {

                    Log.i("MainActivity", "onLost!")
                    flag = false

                }
            }
        )
        return flag
    }
}
