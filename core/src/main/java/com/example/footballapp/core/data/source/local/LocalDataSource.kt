package com.example.footballapp.core.data.source.local

import com.example.footballapp.core.data.source.local.entity.TeamEntity
import com.example.footballapp.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(teamDao: TeamDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(teamDao)
            }
    }

    fun getAllTeam(): Flow<List<TeamEntity>> = teamDao.getAllBundesligaTeam()

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = teamDao.getAllFavoriteTeam()

    fun getSearchTeam(search: String): Flow<List<TeamEntity>> = teamDao.getSearchTeam(search)

    suspend fun insertTeam(teamList: List<TeamEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamEntity, newState: Boolean) {
        team.favorite = newState
        teamDao.updateFavoriteTeam(team)
    }

}