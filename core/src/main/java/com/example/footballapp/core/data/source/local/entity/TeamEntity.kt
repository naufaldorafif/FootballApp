package com.example.footballapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@kotlinx.parcelize.Parcelize
@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teamId")
    var id: String,

    @ColumnInfo(name = "teamName")
    var teamName: String?,

    @ColumnInfo(name = "teamCrest")
    var teamCrest: String?,

    @ColumnInfo(name = "formed")
    var formed: Int?,

    @ColumnInfo(name = "league1")
    var league1: String?,

    @ColumnInfo(name = "league2")
    var league2: String?,

    @ColumnInfo(name = "league3")
    var league3: String?,

    @ColumnInfo(name = "stadium")
    var stadium: String?,

    @ColumnInfo(name = "stadiumImage")
    var stadiumImage: String?,

    @ColumnInfo(name = "stadiumDesc")
    var stadiumDesc: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "location")
    var location: String?,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean
) : Parcelable
