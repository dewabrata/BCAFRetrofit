package com.bcaf.bcafretrofit.service

import com.bcaf.bcafretrofit.model.OMDBDetailResponse
import com.bcaf.bcafretrofit.model.OMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OMDBApiInterface {
    //http://www.omdbapi.com/?apikey=80641bfb&s=Terminator

    @GET("/?apikey=80641bfb")
    fun searchMovie(@Query("s") search:String) : Call<OMDBResponse>

    @GET("/?apikey=80641bfb&s={title}")
    fun searchMovie2(@Path("title") title:String): Call<OMDBResponse>

    @GET("/?apikey=80641bfb")
    fun detailMovie(@Query("i") id:String): Call<OMDBDetailResponse>

    //http://www.omdbapi.com/?apikey=80641bfb&i=tt19869838

}