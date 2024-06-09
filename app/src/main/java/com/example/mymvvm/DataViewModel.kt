package com.example.mymvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel : ViewModel() {

    private val repository = DataRepository()

    private val _data = MutableLiveData<List<MyData>>()
    val data: LiveData<List<MyData>> get() = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchData() {
        repository.getData().enqueue(object : Callback<List<MyData>> {
            override fun onResponse(call: Call<List<MyData>>, response: Response<List<MyData>>) {
                if (response.isSuccessful) {
                    _data.postValue(response.body())
                } else {
                    _error.postValue("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<MyData>>, t: Throwable) {
                _error.postValue("Failure: ${t.message}")
            }
        })
    }
}
