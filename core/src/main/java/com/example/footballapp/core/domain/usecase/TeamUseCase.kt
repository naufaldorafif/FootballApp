package com.example.footballapp.core.domain.usecase

import com.example.footballapp.core.data.source.Resource
import com.example.footballapp.core.domain.model.Team
import java.util.concurrent.Flow

interface TeamUseCase {
    fun getAllTeams(): kotlinx.coroutines.flow.Flow<Resource<List<Team>>>
    fun getSearchTeam(search: String): kotlinx.coroutines.flow.Flow<List<Team>>
    fun getFavoriteTeam(): kotlinx.coroutines.flow.Flow<List<Team>>
    fun setFavoriteTeam(team: Team, state: Boolean)
}