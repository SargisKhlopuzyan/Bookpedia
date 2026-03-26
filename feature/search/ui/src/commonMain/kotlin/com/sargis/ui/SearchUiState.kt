package com.sargis.ui

import com.sargis.coreui.UiText
import com.sargis.domain.model.Movie

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: UiText? = null,
    val movies: List<Movie>? = null,
    val favoriteMovies: List<Movie>? = null,
    val selectedTabIndex: Int = 0
)