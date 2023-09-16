package com.example.harrypotterappnew

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
                        HPImageCard (data)
                    }
                }
            }
        }

@Composable
fun HPImageCard(data: HarryPotterData){
    /*val imagePainter = rememberImagePainter(data = movie.image) //TODO check what's the equivalent*/

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(4.dp)
            .shadow(
                elevation = 2.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Box{

            /*Image(
                painter = imagePainter,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )*/
            Surface (
                color = androidx.compose.material.MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = androidx.compose.material.MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Character: ${data.name}")
                    Text(text = "Hogwarts' House: ${data.house}")
                    Text(text = "Actor: ${data.actor}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI() {
    val gold = Color(0xFFFFD700)
    val deepBlue = Color( 0xFF000080)
    CenterAlignedTopAppBar(
        title = { Text(
            text = "Il mondo di Enrico Vasaio",
            color = gold,
            fontWeight = FontWeight.Bold
        ) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = deepBlue
        )
    )
}

