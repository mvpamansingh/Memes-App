package com.example.memesapp.FirstScreen.Presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun FirstScreen(state: FirstScreenState, event:(FirstScreenEvent)->Unit, viewModel: FirstScreenViewModel)
{



    Column(modifier= Modifier.fillMaxSize()) {


 // MY ErROe       SearchBar(query = , onQueryChange = , onSearch = , active = , onActiveChange = , state =state ) {

       // }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(items = memesList.filter {
                it.name.contains(searchedText, ignoreCase = true)
            }, key = { it.id }) { item ->
                MemeItem(
                    itemName = item.name,
                    itemUrl = item.url,
                    navController = navController
                )
            }


        }
    }
}



