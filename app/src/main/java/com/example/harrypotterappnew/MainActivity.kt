package com.example.harrypotterappnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {
    private val viewModel: HarryPotterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply{
            setKeepOnScreenCondition{
                !viewModel.isReady.value
            }
        }

        setContent {
            HomePage(viewModel)
            /*MyUI()
            HarryPotterScreen(viewModel)*/
        }
    }
}

@Composable
fun HomePage(viewModel: HarryPotterViewModel){
   /* val viewModel: HarryPotterViewModel by viewModels()*/

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyUI()
            HarryPotterScreen(viewModel)
        }
    }

}



