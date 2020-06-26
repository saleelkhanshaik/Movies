package com.example.krishna.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krishna.model.Response
import retrofit2.Call
import retrofit2.Callback

class MainList:ViewModel() {
    private val users: MutableLiveData<Response> by lazy {
        MutableLiveData<Response>().also {
            loadMovies()
        }
    }

    fun getList(): MutableLiveData<Response> {
        return users
    }
    private fun loadMovies(){

    }
//    fun callMoviesListAPI(filter: String?) {
////        setDatavisibiity(1)
//        val call: Call<Response> = apiSerivce.movieList(1,filter)
//        call.enqueue(object : Callback<Response> {
//            override fun onFailure(call: Call<Response>, t: Throwable) {
//                //Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
////                setDatavisibiity(2)
//            }
//
//            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
////                Toast.makeText(
////                    this@MainActivity,
////                    "SUCCESS.... " + response.body()?.search.toString(),
////                    Toast.LENGTH_SHORT
////                ).show()
////                setDatavisibiity(3)
////                setAdapter(response.body())
//            }
//
//        })
//    }
}