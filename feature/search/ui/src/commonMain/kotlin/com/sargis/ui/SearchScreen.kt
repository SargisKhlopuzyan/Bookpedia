package com.sargis.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.SubcomposeAsyncImage
import com.sargis.coreui.DarkBlue
import com.sargis.ui.components.MoviesSearchBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onMovieClick: (String) -> Unit
) {

    val viewModel = koinViewModel<SearchViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()

    SearchScreenContent(
        modifier = modifier,
        query = query,
        onAction = { action ->
            when (action) {
                is MovesAction.OnMoveClick -> onMovieClick(action.move.id)
                else -> viewModel.onAction(action)
            }
        },
        uiState = uiState,
        onClick = onMovieClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchScreenContent(
    modifier: Modifier = Modifier,
    query: String,
    onAction: (MovesAction) -> Unit,
    uiState: SearchUiState,
    onClick: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MoviesSearchBar(
                searchQuery = query,
                onSearchQueryChange = {
                    onAction(MovesAction.OnSearchQueryChange(it))
                },
                onImeSearch = {
                    keyboardController?.hide()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBlue)
                    .statusBarsPadding()
                    .widthIn(400.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    ) { innerPadding ->

        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (uiState.error != null) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = uiState.error.asString())
            }
        }

        uiState.movies?.let { results ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                items(
                    count = results.size,
                    key = { results[it].id },
                    contentType = { results[it].id }) { index ->
                    val item = results[index]
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                            .height(300.dp)
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { onClick(results[index].id) }
                            .clip(RoundedCornerShape(12.dp)),
                        model = item.imageUrl, loading = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp), contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }, error = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp), contentAlignment = Alignment.Center
                            ) {
                                Text("Something went wrong.")
                            }
                        }, contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenContentPreview() {
    SearchScreenContent(
        query = "Harry Potter",
        uiState = SearchUiState(),
        onAction = {},
        onClick = {}
    )
}