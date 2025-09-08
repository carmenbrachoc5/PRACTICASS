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
fun CowboysView(navController: NavController) {
    // Color Azul Marino Cowboys (Hex: #041E42)
    val CowboysNavy = Color(0xFF041E42)


    val teamImages = listOf(
        R.drawable.cow,
        R.drawable.cowbo,
        R.drawable.cowb,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dallas Cowboys", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cowboys),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CowboysNavy, // Azul marino Cowboys
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
            Text("Los Baltimore Ravens se fundaron en 1996 cuando Art Modell, dueño de los " +
                    "Cleveland Browns, trasladó su equipo a Baltimore. Cleveland para un equipo de expansión que se " +
                    "formaría más tarde, por lo que los Ravens se consideran legalmente una nueva franquicia. " +
                    " Se establecieron rápidamente como una" +
                    " franquicia exitosa, principalmente gracias a sus sólidas defensas.")
            Text("Su estadio histórico fue el Memorial Stadium (1996-1997), y su estadio actual es " +
                    "el M&T Bank Stadium, inaugurado en 1998.")
            Text("Dos títulos de Super Bowl: Super Bowl XXXV (2000) y Super Bowl XLVII (2012).")

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
                // Genera una Card con una imagen por cada recurso en la lista
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
