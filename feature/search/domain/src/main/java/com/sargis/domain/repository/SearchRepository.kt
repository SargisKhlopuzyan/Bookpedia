package com.sargis.domain.repository

import com.sargis.domain.model.Movie

interface SearchRepository {
    suspend fun search(q: String): Result<List<Movie>>
}