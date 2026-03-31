package com.sargis.moviesearch.feature.details.domain.usecase

import com.sargis.moviesearch.core.domain.DataError
import com.sargis.moviesearch.core.domain.Result
import com.sargis.moviesearch.feature.details.domain.model.MovieDetails
import com.sargis.moviesearch.feature.details.domain.repository.DetailsRepository

class GetMovieDetailsUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend fun execute(movieId: String): Result<MovieDetails, DataError> {
        return detailsRepository.getMovieDetails(movieId)
    }
}