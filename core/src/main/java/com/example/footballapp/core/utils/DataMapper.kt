package com.example.footballapp.core.utils

import com.example.footballapp.core.data.source.local.entity.TeamEntity
import com.example.footballapp.core.data.source.remote.response.TeamResponse
import com.example.footballapp.core.domain.model.Team

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamResponse>): List<TeamEntity> {
        val teamList = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                id = it.id,
                teamName = it.teamName,
                teamCrest = it.teamCrest,
                formed = it.formed,
                league1 = it.league1,
                league2 = it.league2,
                league3 = it.league3,
                stadium = it.stadium,
                stadiumImage = it.stadiumImage,
                stadiumDesc = it.stadiumDesc,
                description = it.description,
                location = it.location,
                favorite = false
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Team> =
        input.map {
            Team(
                id = it.id,
                teamName = it.teamName,
                teamCrest = it.teamCrest,
                formed = it.formed,
                league1 = it.league1,
                league2 = it.league2,
                league3 = it.league3,
                stadium = it.stadium,
                stadiumImage = it.stadiumImage,
                stadiumDesc = it.stadiumDesc,
                description = it.description,
                location = it.location,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input: Team) = TeamEntity(
        id = input.id,
        teamName = input.teamName,
        teamCrest = input.teamCrest,
        formed = input.formed,
        league1 = input.league1,
        league2 = input.league2,
        league3 = input.league3,
        stadium = input.stadium,
        stadiumImage = input.stadiumImage,
        stadiumDesc = input.stadiumDesc,
        description = input.description,
        location = input.location,
        favorite = input.favorite
    )
}