package com.sargis.moviesearch.core.data.di

import com.sargis.moviesearch.core.data.api.KtorRemoteMovieDataSource
import com.sargis.moviesearch.core.data.client.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module

fun getCoreDataModule(): Module {
    return module {
        single {
            KtorRemoteMovieDataSource(HttpClientFactory.getInstance())
        }
    }
}