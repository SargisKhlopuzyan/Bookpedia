package com.sargis.ui

import com.sargis.domain.model.Movie

sealed interface MovesAction {
    data class OnSearchQueryChange(val query: String) : MovesAction
    data class OnMoveClick(val move: Movie) : MovesAction
    data class OnTabSelected(val tabIndex: Int) : MovesAction
}