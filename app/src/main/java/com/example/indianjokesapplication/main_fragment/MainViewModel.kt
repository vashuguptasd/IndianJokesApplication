package com.example.indianjokesapplication.main_fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indianjokesapplication.R
import com.example.indianjokesapplication.dao.Repo
import com.example.indianjokesapplication.dao.Table
import com.example.indianjokesapplication.joke_api.JokeDataClassItem
import com.example.indianjokesapplication.joke_api.JokesApi
import com.example.indianjokesapplication.joke_api.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val _liveList = MutableLiveData<List<JokeDataClassItem>>()
    val liveList : LiveData<List<JokeDataClassItem>> = _liveList

    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status> = _status

    init {
        launchApi()
    }

    private fun launchApi() {
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                val list = JokesApi.getJokes.getJokes()
                _liveList.value = list
                _status.value = Status.DONE


            }
            catch (t : Throwable){
                _status.value = Status.FAIL
                Log.e("testApplication",t.toString())
            }
        }
    }

}