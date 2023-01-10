package com.bcaf.bcafretrofit

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bcaf.bcafretrofit.model.PostDummyData
import com.bcaf.bcafretrofit.model.ResponsePostDummyData
import com.bcaf.bcafretrofit.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_post_data_dummy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDataDummy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_data_dummy)
        txtTags.setOnClickListener(View.OnClickListener {

            createMultipleSelectDialog()
        })

        btnPost.setOnClickListener(View.OnClickListener { v->

            var dummyData = PostDummyData("60d0fe4f5311236168a109f4",
                txtImage.text.toString(),txtText.text.toString(),
                txtLikes.text.toString().toInt(),selectionList)
            NetworkConfig().getServiceDummy().postData(dummyData).enqueue( object : Callback<ResponsePostDummyData>{
                override fun onResponse(
                    call: Call<ResponsePostDummyData>,
                    response: Response<ResponsePostDummyData>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext,response.message(),Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponsePostDummyData>, t: Throwable) {
                    Log.e("error post", t.printStackTrace().toString())
                }

            })

        })
    }


    var selectionList = mutableListOf<String>()
    val listItem = arrayOf("Movies","Actor","Fun")
    val listChecked = booleanArrayOf(false,false,false)

    fun createMultipleSelectDialog(){

        val builder = AlertDialog.Builder(this)

        builder.setTitle("Choose Tags")

        builder.setMultiChoiceItems(listItem,listChecked){
            dialog,which,ischecked ->
            listChecked[which] = ischecked
        }

        builder.setCancelable(false)
        builder.setNegativeButton("Cancel"){
            dialog,which ->
        }
        builder.setPositiveButton("Submit"){
            dialog,which ->

            selectionList.clear()

            for((index,value) in listChecked.withIndex()){
                if(value){
                    selectionList.add(listItem[index])

                }
            }
            txtTags.setText("")
            for (listItem in selectionList){
                txtTags.append("${listItem}, ")
            }

            txtTags.setText(txtTags.text.toString().dropLast(2))
        }

        builder.create()

        val alertDialog = builder.create()
        alertDialog.show()



    }
}