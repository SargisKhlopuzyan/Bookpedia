package com.sargis.domain.repository

import com.sargis.domain.model.MovieDetails

interface DetailsRepository {
    suspend fun getMovieDetails(movieId: String): Result<MovieDetails>
}