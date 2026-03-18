package com.sargis.data.di

import com.sargis.data.repository.DetailsRepositoryImpl
import com.sargis.domain.repository.DetailsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDetailsDataModule(): Module {
    return module {
        single<DetailsRepository> {
            DetailsRepositoryImpl(get())
        }
    }
}