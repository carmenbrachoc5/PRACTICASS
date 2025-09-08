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
fun JaguarsView(navController: NavController) {

    val JaguarsTeal = Color(0xFF006778)


    val teamImages = listOf(
        R.drawable.ja,
        R.drawable.jagu,
        R.drawable.jag,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Jacksonville Jaguars", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.jaguars),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = JaguarsTeal, // Teal de los Jaguars
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
            Text("Los Jacksonville Jaguars son una franquicia de expansión de la NFL, " +
                    "otorgada a la ciudad de Jacksonville, Florida, en 1993, y comenzaron a jugar " +
                    "en la temporada de 1995 junto con los Carolina Panthers.")
            Text("Su estadio actual, donde han jugado desde sus inicios, es el EverBank Stadium" +
                    " (anteriormente conocido como TIAA Bank Field y otros nombres), inaugurado en 1995.")
            Text("Cero títulos de Super Bowl. Cero títulos de Conferencia (han llegado dos veces al" +
                    " juego de Campeonato de la AFC).")

            Spacer(modifier = Modifier.height(16.dp))


            Text("Momentos:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Altura fija para la lista horizontal
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Espacio entre ítems
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