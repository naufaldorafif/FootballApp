package com.example.footballapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.core.domain.usecase.TeamUseCase

class FavoriteViewModel(teamUseCase: TeamUseCase): ViewModel() {
    val favTeam = teamUseCase.getFavoriteTeam().asLiveData()
}