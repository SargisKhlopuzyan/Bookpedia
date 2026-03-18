package com.sargis.domain.usecase

import com.sargis.domain.model.MovieDetails
import com.sargis.domain.repository.DetailsRepository

class GetMovieDetailsUseCase(
    private val detailsRepository: DetailsRepository
) {
    suspend fun execute(movieId: String): Result<MovieDetails> {
        return detailsRepository.getMovieDetails(movieId)
    }
}