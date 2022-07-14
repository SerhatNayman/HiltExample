package com.serosoft.hiltexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serosoft.hiltexample.network.RecyclerData
import com.serosoft.hiltexample.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository) :
    ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<RecyclerData>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDAtaObserver(): MutableLiveData<List<RecyclerData>> {

        return liveDataList

    }

    fun loadListOfData() {

        repository.makeApiCall("ny", liveDataList)

    }
}