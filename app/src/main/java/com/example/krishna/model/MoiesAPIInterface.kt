package com.example.krishna.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoiesAPIInterface {
    @GET("/?type=movie&apikey=5d81e1ce")
    fun getMoviesListbasedOntheSearch(@Query("page") page:Int,@Query("s") seachChar:String?):Call<Response>

    @GET("/?plot=full&apikey=5d81e1ce")
    fun getMoviesDeatils(@Query("t") seachChar:String?):Call<MovieDetails>
}