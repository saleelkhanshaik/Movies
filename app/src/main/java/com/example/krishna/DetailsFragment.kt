package com.example.krishna

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.krishna.common.CircleTransform
import com.example.krishna.model.MovieDetails
import com.example.krishna.model.MoviesApiService
import com.example.krishna.model.SearchItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : AppCompatActivity() {
    private val apiSerivce = MoviesApiService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details)
        val moviewName:String =intent.getStringExtra("movieName")!!
        callDetailsAPI(moviewName)
    }

    private fun callDetailsAPI(moviewName: String) {
        val call: Call<MovieDetails> = apiSerivce.movieDeatils(moviewName)
        call.enqueue(object:Callback<MovieDetails>{
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                updateUI(response.body())
            }

        })

    }

    private fun updateUI(body: MovieDetails?) {
        movieName.text = body?.title
        yearTxt.text = body?.year
        ratedtxt.text = body?.rated
        releasedTxt.text = body?.released
        genreTxt.text = body?.genre
        languageTxt.text = body?.language
        plotTxt.text =body?.plot
        Picasso.get()
            .load(body?.poster)
            .centerCrop()
            .transform(CircleTransform(50,0))
            .fit()
            .into(moviePoster,object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    detailsProgress.setVisibility(View.GONE)
                }

                override fun onError(e: Exception?) {

                }})
    }

}
