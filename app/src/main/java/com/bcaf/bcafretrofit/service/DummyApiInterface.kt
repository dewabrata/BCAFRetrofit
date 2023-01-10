package com.bcaf.bcafretrofit.service

import com.bcaf.bcafretrofit.model.PostDummyData
import com.bcaf.bcafretrofit.model.ResponsePostDummyData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface DummyApiInterface {

//    @Headers("app-id:63bcc99843b161608eeac665")
    @POST("post/create/")
    fun postData(@Body dummyData: PostDummyData): Call<ResponsePostDummyData>
}