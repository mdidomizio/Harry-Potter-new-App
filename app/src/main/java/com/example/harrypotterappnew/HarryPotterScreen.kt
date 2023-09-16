package com.example.harrypotterappnew

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun HarryPotterScreen(viewModel: HarryPotterViewModel) {
    val data by viewModel.harryPotterData.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchHarryPotterApi()
    }

    LazyColumn() {
        if(data.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        } else {
                items(data) { data->
                   /* HPImageCard (data)*/

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(text = "Character: ${data.name}")
                        Text(text = "Hogwarts' House: ${data.house}")
                        Text(text = "Actor: ${data.actor}")
                    }
            }
        }
        }
}

/*@Composable
fun HPImageCard(){
    val imagePainter = rememberImagePainter(data = movie.image) //TODO check what's the equivalent

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Box{

            Image(
                painter = imagePainter,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )
            Surface (
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Real Name: ${movie.actor}") //TODO check what's the equivalent
                    Text(text = "Actor Name: ${movie.name}") //TODO check what's the equivalent
                }
            }
        }
    }
}*/

/*
Card(
modifier = Modifier
.fillMaxWidth()
.padding(8.dp)
) {
    Text(text = "Character: ${data.name}")
    Text(text = "Hogwarts' House: ${data.house}")
    Text(text = "Actor: ${data.actor}")
}*/
