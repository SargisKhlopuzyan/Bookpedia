package com.sargis.ui

import com.sargis.domain.model.Movie

sealed interface MoviesAction {
    data class OnSearchQueryChange(val query: String) : MoviesAction
    data class OnMovieClick(val move: Movie) : MoviesAction
    data class OnTabSelected(val tabIndex: Int) : MoviesAction
}