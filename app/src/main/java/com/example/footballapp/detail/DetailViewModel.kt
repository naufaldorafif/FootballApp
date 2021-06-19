package com.example.footballapp.detail

import androidx.lifecycle.ViewModel
import com.example.footballapp.core.domain.model.Team
import com.example.footballapp.core.domain.usecase.TeamUseCase

class DetailViewModel(private val teamUseCase: TeamUseCase): ViewModel() {
    fun setFavoriteTeam(team: Team, newStatus: Boolean) = teamUseCase.setFavoriteTeam(team, newStatus)
}