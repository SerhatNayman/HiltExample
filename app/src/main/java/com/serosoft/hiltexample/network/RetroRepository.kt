package com.serosoft.hiltexample.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroIstance: RetroServiceInstance) {

    fun makeApiCall(query: String, liveData: MutableLiveData<List<RecyclerData>>) {

        val call: retrofit2.Call<RecyclerList> = retroIstance.getDataFromAPI(query)

        call?.enqueue(object : retrofit2.Callback<RecyclerList> {

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {

                liveData.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveData.postValue(response.body()?.items!!)
            }
        })
    }

}