package com.example.wikipediatest1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        /*Commented so as not to remove the code snippet entirely.
        value = "This is home Fragment"*/

    }
    val text: LiveData<String> = _text
}