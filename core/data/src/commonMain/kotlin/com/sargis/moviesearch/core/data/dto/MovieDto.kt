package com.sargis.moviesearch.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    //    val adult: Boolean,
    //    val backdrop_path: String,
    //    val genre_ids: List<Int>,
    val id: Int,
    //    val original_language: String,
    //    val original_title: String,
    //    val overview: String,
    //    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String? = null,
    val title: String,
    //    val video: Boolean,
    @SerialName("vote_average")
    val averageVote: Double? = null,
    @SerialName("vote_count")
    val voteCount: Int? = null
)