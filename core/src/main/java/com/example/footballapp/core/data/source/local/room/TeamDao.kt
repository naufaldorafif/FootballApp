package com.example.footballapp.core.data.source.local.room

import androidx.room.*
import com.example.footballapp.core.data.source.local.entity.TeamEntity
import java.util.concurrent.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getAllBundesligaTeam(): kotlinx.coroutines.flow.Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE teamName LIKE '%' || :search || '%'")
    fun getSearchTeam(search: String): kotlinx.coroutines.flow.Flow<List<TeamEntity>>

    @Query("SELECT * FROM team where favorite = 1")
    fun getAllFavoriteTeam(): kotlinx.coroutines.flow.Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<TeamEntity>)

    @Update
    fun updateFavoriteTeam(team: TeamEntity)
}