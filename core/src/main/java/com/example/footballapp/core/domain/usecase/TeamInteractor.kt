package com.example.footballapp.core.domain.usecase

import com.example.footballapp.core.data.source.Resource
import com.example.footballapp.core.domain.model.Team
import com.example.footballapp.core.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow

class TeamInteractor(private val teamRespository: ITeamRepository): TeamUseCase {
    override fun getAllTeams() = teamRespository.getAllTeam()

    override fun getSearchTeam(search: String): Flow<List<Team>> = teamRespository.getSearchTeam(search)

    override fun getFavoriteTeam() = teamRespository.getFavoriteTeam()

    override fun setFavoriteTeam(team: Team, state: Boolean) = teamRespository.setFavoriteTeam(team, state)

}