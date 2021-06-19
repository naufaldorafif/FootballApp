package com.example.footballapp.core.domain.repository

import com.example.footballapp.core.data.source.Resource
import com.example.footballapp.core.data.source.local.entity.TeamEntity
import com.example.footballapp.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getAllTeam(): Flow<Resource<List<Team>>>

    fun getSearchTeam(search: String): Flow<List<Team>>

    fun getFavoriteTeam(): Flow<List<Team>>

    fun setFavoriteTeam(team: Team, state: Boolean)

}