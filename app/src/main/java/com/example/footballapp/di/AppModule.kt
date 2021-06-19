package com.example.footballapp.di

import com.example.footballapp.core.domain.usecase.TeamInteractor
import com.example.footballapp.core.domain.usecase.TeamUseCase
import com.example.footballapp.detail.DetailViewModel
import com.example.footballapp.ui.search.SearchViewModel
import com.example.footballapp.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}