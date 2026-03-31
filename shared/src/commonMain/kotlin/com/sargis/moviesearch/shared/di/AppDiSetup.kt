package com.sargis.moviesearch.shared.di

import com.sargis.moviesearch.core.data.di.getCoreDataModule
import com.sargis.moviesearch.feature.details.data.di.getDetailsDataModule
import com.sargis.moviesearch.feature.details.domain.di.getDetailsDomainModule
import com.sargis.moviesearch.feature.details.ui.di.getDetailsUiModule
import com.sargis.moviesearch.feature.search.data.di.getSearchDataModule
import com.sargis.moviesearch.feature.search.domain.di.getSearchDomainModule
import com.sargis.moviesearch.feature.search.ui.di.getSearchUiModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            getCoreDataModule(),

            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchUiModule(),

            getDetailsDataModule(),
            getDetailsDomainModule(),
            getDetailsUiModule(),
        )
    }
}