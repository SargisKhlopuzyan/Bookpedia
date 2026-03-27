package com.sargis.ui

import androidx.compose.runtime.Immutable
import com.sargis.coreui.UiText
import com.sargis.domain.model.Movie

@Immutable
data class SearchUiState(
    val isLoading: Boolean = false,
    val error: UiText? = null,
    val searchedMovies: List<Movie> = emptyList(),
    val favoriteMovies: List<Movie> = emptyList(),
    val selectedTabIndex: Int = 0
)