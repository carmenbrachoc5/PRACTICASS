
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
fun RavensView(navController: NavController) {
    // Color Morado de los Ravens (Hex: #241773)
    val RavensPurple = Color(0xFF241773)

    // Lista de las imágenes para el LazyRow
    val teamImages = listOf(
        R.drawable.ra, // **Asegúrate de tener estos recursos**
        R.drawable.rave,
        R.drawable.rav,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Baltimore Ravens", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ravens),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = RavensPurple,
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
            Text("Los Baltimore Ravens se fundaron en 1996 cuando Art Modell, dueño de los Cleveland Browns," +
                    " trasladó su equipo a Baltimore.  El nombre 'Ravens' " +
                    "(Cuervos) fue elegido por los aficionados en honor al poema de Edgar Allan Poe, quien " +
                    "vivió en Baltimore. ")
            Text("Su estadio histórico fue el Memorial Stadium (1996-1997), y su estadio actual es el " +
                    "M&T Bank Stadium, inaugurado en 1998.")
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
