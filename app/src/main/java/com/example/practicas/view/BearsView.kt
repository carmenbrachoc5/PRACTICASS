package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BearsView(navController: NavController) {

    val BearsNavy = Color(0xFF0B162C)


    val teamImages = listOf(
        R.drawable.be,
        R.drawable.bear,
        R.drawable.bea,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chicago Bears", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.bears),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BearsNavy,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text("Historia", style = MaterialTheme.typography.headlineSmall)
            Text("Los Chicago Bears son una de las dos franquicias charter originales de la NFL que aún existen" +
                    " (junto con los Cardinals). Se fundaron como los Decatur Staleys en 1919 y se unieron a la liga " +
                    "en 1920. Se mudaron a Chicago en 1921 y cambiaron su nombre a Bears en 1922. Son uno de los equipos" +
                    " más laureados en la historia de la NFL, con múltiples campeonatos antes de la era del Super Bowl," +
                    " con figuras legendarias como George Halas.")
            Text("Jugaron en el Wrigley Field, hogar de los Chicago Cubs, desde 1921 hasta 1970. Su estadio " +
                    "actual es el Soldier Field (desde 1971, con una excepción por renovación en 2002).")
            Text("Un título de Super Bowl: Super Bowl XX (1985). Ocho títulos de Campeonato de la NFL " +
                    "(antes de 1970).")
            Spacer(modifier = Modifier.height(16.dp))


            Text("Momentos:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                items(teamImages) { imageResId ->
                    Card(
                        modifier = Modifier
                            .width(250.dp)
                            .fillMaxHeight(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}