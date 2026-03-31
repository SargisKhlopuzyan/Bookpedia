package com.sargis.moviesearch.feature.search.domain.usecase

import com.sargis.moviesearch.core.domain.DataError
import com.sargis.moviesearch.core.domain.Result
import com.sargis.moviesearch.feature.search.domain.model.Movie
import com.sargis.moviesearch.feature.search.domain.repository.SearchRepository

class SearchUseCase(
    private val searchRepository: SearchRepository
) {
    suspend fun execute(q: String): Result<List<Movie>, DataError> {
        return searchRepository.search(q)
    }
}