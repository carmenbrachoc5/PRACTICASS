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
fun EaglesView(navController: NavController) {

    val EaglesSilver = Color(0xFFA5ACAF)


    val teamImages = listOf(
        R.drawable.eg,
        R.drawable.egle,
        R.drawable.egl,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Philadelphia Eagles", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.eagles),
                            contentDescription = "Volver",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = EaglesSilver,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
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
            Text("Los Philadelphia Eagles se fundaron en 1933, reemplazando a los extintos" +
                    " Frankford Yellow Jackets. Ganaron dos campeonatos de la NFL consecutivos en la " +
                    "era previa al Super Bowl (1948 y 1949). Tuvieron otro título de campeonato en 1960. " +
                    "A lo largo de su historia han tenido varios períodos de éxito y han llegado a varios " +
                    "Super Bowls, aunque a menudo se quedaron cortos hasta que finalmente ganaron su primer título" +
                    " a principios del siglo XXI.")
            Text("Su estadio histórico fue el Veterans Stadium (1971-2002). Su estadio actual es " +
                    "el Lincoln Financial Field, inaugurado en 2003.")
            Text("Dos títulos de Super Bowl: Super Bowl LII (2017) y Super Bowl LIX (2024)." +
                    " Tres títulos de Campeonato de la NFL (antes de 1970).")

            // --- LAZYROW DE IMÁGENES ---
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
            // ---------------------------------------------
        }
    }
}
