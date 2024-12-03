package jafari.movie.presentation.feature.movielist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jafari.movie.domain.models.Movie

@Composable
fun MovieList(
  list: List<Movie>,
  onItemClicked: (Movie) -> Unit,
  modifier: Modifier = Modifier,
  gridState: LazyGridState = rememberLazyGridState(),
) {
  LazyVerticalGrid(
    columns = GridCells.Adaptive(160.dp),
    state = gridState,
    contentPadding = PaddingValues(horizontal = 8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier,
  ) {
    items(
      items = list,
      key = { item -> item.id },
    ) { listItem ->
      MovieItemCard (
        item = listItem,
        onItemClicked = {  onItemClicked(listItem) },
      )
    }
  }
}