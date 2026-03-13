package com.sargis.data.di

import com.sargis.data.repository.SearchRepositoryImpl
import com.sargis.domain.repository.SearchRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getSearchDataModule(): Module {
    return module {
        single<SearchRepository> {
            SearchRepositoryImpl(get())
        }
    }
}