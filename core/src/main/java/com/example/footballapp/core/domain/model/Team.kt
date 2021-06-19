package com.example.footballapp.core.domain.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Team(
    var id: String,
    var teamName: String?,
    var teamCrest: String?,
    var formed: Int?,
    var league1: String?,
    var league2: String?,
    var league3: String?,
    var stadium: String?,
    var stadiumImage: String?,
    var stadiumDesc: String?,
    var description: String?,
    var location: String?,
    var favorite: Boolean
): Parcelable
