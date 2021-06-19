package com.example.footballapp.core.data.source.remote.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class TeamResponse (
    @field:SerializedName("idTeam")
    var id: String,

    @field:SerializedName("strTeam")
    var teamName: String,

    @field:SerializedName("intFormedYear")
    var formed: Int,

    @field:SerializedName("strLeague")
    var league1: String,

    @field:SerializedName("strLeague2")
    var league2: String,

    @field:SerializedName("strLeague3")
    var league3: String,

    @field:SerializedName("strStadium")
    var stadium: String,

    @field:SerializedName("strTeamBadge")
    var teamCrest: String,

    @field:SerializedName("strStadiumThumb")
    var stadiumImage: String,

    @field:SerializedName("strStadiumDescription")
    var stadiumDesc: String,

    @field:SerializedName("strDescriptionEN")
    var description: String,

    @field:SerializedName("strStadiumLocation")
    var location: String
    )