package com.example.shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    companion object {
        val itemList: MutableLiveData<Item> by lazy {
            MutableLiveData<Item>()
        }
        val itemString:MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        val numberInt:MutableLiveData<Int> by lazy {
            MutableLiveData<Int>()
        }
    }
}