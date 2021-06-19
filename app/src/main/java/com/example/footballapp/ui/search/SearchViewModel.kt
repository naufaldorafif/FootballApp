package com.example.footballapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.core.domain.usecase.TeamUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class SearchViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun search(search: String) = teamUseCase.getSearchTeam(search).asLiveData()
}