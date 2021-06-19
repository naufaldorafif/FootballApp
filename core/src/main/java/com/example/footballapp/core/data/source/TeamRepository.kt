package com.example.footballapp.core.data.source

import com.example.footballapp.core.data.source.local.LocalDataSource
import com.example.footballapp.core.data.source.remote.RemoteDataSource
import com.example.footballapp.core.data.source.remote.network.ApiResponse
import com.example.footballapp.core.data.source.remote.response.TeamResponse
import com.example.footballapp.core.domain.model.Team
import com.example.footballapp.core.domain.repository.ITeamRepository
import com.example.footballapp.core.utils.AppExecutors
import com.example.footballapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ITeamRepository {

    companion object {
        @Volatile
        private var instance: TeamRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TeamRepository =
            instance ?: synchronized(this) {
                instance ?: TeamRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTeam(): Flow<Resource<List<Team>>> =
        object : NetworkBoundResource<List<Team>, List<TeamResponse>>(){
            override fun loadFromDB(): Flow<List<Team>> {
                return localDataSource.getAllTeam().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Team>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> =
                remoteDataSource.getAllTeam()

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
            }
        }.asFlow()

    override fun getSearchTeam(search: String): Flow<List<Team>> {
        return localDataSource.getSearchTeam(search).map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun getFavoriteTeam(): Flow<List<Team>> {
        return localDataSource.getFavoriteTeam().map { DataMapper.mapEntitiesToDomain(it) }
    }



    override fun setFavoriteTeam(team: Team, state: Boolean) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }
}