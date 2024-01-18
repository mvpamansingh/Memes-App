package com.example.memesapp.FirstScreen.Presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.memesapp.FirstScreen.Data.remote.model.Meme


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
//            items(items = memesList.filter {
//                it.name.contains(searchedText, ignoreCase = true)
//            }, key = { it.id }) { item ->
//                MemeItem(
//                    itemName = item.name,
//                    itemUrl = item.url,
//                    navController = navController
//                )
//            }
            items(state.memesList)
            {item->

                MemeItem(meme = item, event= { event -> viewModel.event(event) })
            }


        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MemeItem(meme: Meme, event:(FirstScreenEvent)->Unit)
{


    val imageState= rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(meme.url).size(Size.ORIGINAL)
            .build()
    ).state

    Card(
        modifier= Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable {
                //navController.navigate("DetailsScreen?name=$itemName&url=$itemUrl")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffffc107)
        )
    ){
        Column(
            modifier=Modifier
                .padding(6.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            if (imageState is AsyncImagePainter.State.Error) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }


            if(imageState is AsyncImagePainter.State.Success)
            {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                    ,painter = imageState.painter,
                    contentDescription = meme.name,
                    contentScale = ContentScale.Crop)
            }



            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = meme.name,
                modifier=Modifier
                    .fillMaxWidth()
                    .basicMarquee(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}

