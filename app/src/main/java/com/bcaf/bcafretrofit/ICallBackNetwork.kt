package com.bcaf.bcafretrofit

import com.bcaf.bcafretrofit.model.SearchItem

interface ICallBackNetwork {

    fun onFinish(data :List<SearchItem>)
    fun onFailed()
}