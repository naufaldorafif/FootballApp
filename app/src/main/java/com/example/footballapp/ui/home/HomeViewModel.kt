package com.example.footballapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.core.domain.usecase.TeamUseCase

class HomeViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {

    val team = teamUseCase.getAllTeams().asLiveData()

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
}