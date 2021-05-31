package com.example.etrite.ui.chatroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatroomViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is chatroom Fragment"
    }
    val text: LiveData<String> = _text
}