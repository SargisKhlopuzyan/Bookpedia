package com.sargis.domain.di

import com.sargis.domain.usecase.GetMovieDetailsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDetailsDomainModule(): Module {
    return module {
        // single
        factory {
            GetMovieDetailsUseCase(get())
        }
    }
}