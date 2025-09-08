package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow // Importar LazyRow
import androidx.compose.foundation.lazy.items // Importar items para LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale // Importar ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DolphinsView(navController: NavController) {
    // Color Aqua Dolphins (Hex: #008E97)
    val DolphinsAqua = Color(0xFF008E97)


    val teamImages = listOf(
        R.drawable.dol, // **Asegúrate de tener estos recursos**
        R.drawable.dolph,
        R.drawable.dolp,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Miami Dolphins", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.dolphins),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DolphinsAqua, // Azul clarito Dolphins
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
            Text("Los Miami Dolphins se fundaron en 1966 como la novena franquicia de" +
                    " expansión de la American Football League (AFL). Se unieron a la NFL en 1970 tras la fusión de las dos " +
                    "ligas. Son el único equipo en la historia de la NFL en lograr una temporada perfecta " +
                    "(invicta en temporada regular y playoffs) en 1972, culminando con la victoria en el Super Bowl VII. " +
                    "Ganaron un segundo Super Bowl consecutivo el año siguiente (Super Bowl VIII).")
            Text("Su primer hogar fue el Orange Bowl en Miami, hasta que se mudaron a su propio estadio, " +
                    "inaugurado en 1987 (con nombres como Hard Rock Stadium, entre otros, a lo largo de los años).")
            Text("Dos títulos de Super Bowl: Super Bowl VII (1972) y Super Bowl VIII (1973).")

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
