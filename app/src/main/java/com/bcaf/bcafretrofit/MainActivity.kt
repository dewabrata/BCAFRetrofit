package com.bcaf.bcafretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.bcaf.bcafretrofit.fragment.ListMovie
import com.bcaf.bcafretrofit.model.OMDBResponse
import com.bcaf.bcafretrofit.model.SearchItem
import com.bcaf.bcafretrofit.service.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListMovieFragment()



    }

    fun showListMovieFragment(){
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameFragment, ListMovie.newInstance("",""))
        ft.commit()
    }

    fun searchMovie(title:String, callbackNetwork : ICallBackNetwork) {

        var data : List<SearchItem>? = null
        NetworkConfig().getServiceOMDB().searchMovie(title).enqueue(object : Callback<OMDBResponse>{
            override fun onResponse(call: Call<OMDBResponse>, response: Response<OMDBResponse>) {
                Log.d("Response OMDB APi search", response.toString())

                if(response.body()?.search!=null) {
                    data = (response.body()?.search as List<SearchItem>)
                    callbackNetwork.onFinish(data!!)
                }
            }

            override fun onFailure(call: Call<OMDBResponse>, t: Throwable) {
               Log.e("Failed Response", t.message.toString())
                callbackNetwork.onFailed()
            }

        })


    }


}