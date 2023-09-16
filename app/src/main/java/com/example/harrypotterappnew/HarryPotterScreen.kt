package com.example.harrypotterappnew

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HarryPotterScreen(viewModel: HarryPotterViewModel) {
    val data by viewModel.harryPotterData.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchHarryPotterApi()
    }

    Column() {
        if(data.isEmpty()) {
            //show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            LazyColumn {
                items(data) { data->

                    Text(text = "Actor's Name: ${data.actor}")
                    Text(text = "Character's Name: ${data.alternateNames}")
                    Text(text = "Hogwarts' House: ${data.house}")

            }


            }

        }


        }
}