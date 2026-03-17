package com.sargis.ui.di

import com.sargis.ui.SearchViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val searchViewModelModule = module {
    single {
        SearchViewModel(get())
    }
}

actual fun getSearchUiModule(): Module {
    return searchViewModelModule
}

class SearchViewModelProvider() : KoinComponent {
    fun provideSearchViewModel(): SearchViewModel = get()
}