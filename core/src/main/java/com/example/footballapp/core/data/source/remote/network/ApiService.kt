package com.example.footballapp.core.data.source.remote.network

import com.example.footballapp.core.data.source.remote.response.ListTeamResponse
import com.example.footballapp.core.data.source.remote.response.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("lookup_all_teams.php?id=4331")
    suspend fun getList(): ListTeamResponse

    @GET("searchteams.php?t={query}")
    suspend fun getSearch(
        @Path("query") query: String
    )
}