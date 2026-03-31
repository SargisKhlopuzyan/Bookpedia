package com.sargis.moviesearch.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsResponseDto(
//    val adult: Boolean,
//    val backdrop_path: String,
//    val belongs_to_collection: BelongsToCollection,
//    val budget: Int,
//    val genres: List<Genre>,
//    val homepage: String,
    val id: Int,
//    val imdb_id: String,
    @SerialName("origin_country")
    val originCountry: List<String>,
    @SerialName("original_language")
    val originalLanguage: String,
//    val original_title: String,
    val overview: String,
//    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String?,
//    val production_companies: List<ProductionCompany>,
//    val production_countries: List<ProductionCountry>,
    @SerialName("release_date")
    val releaseDate: String,
//    val revenue: Int,
//    val runtime: Int,
//    val spoken_languages: List<SpokenLanguage>,
//    val status: String,
//    val tagline: String,
    val title: String,
//    val video: Boolean,
    @SerialName("vote_average")
    val averageVote: Double,
    @SerialName("vote_count")
    val voteCount: Int
)