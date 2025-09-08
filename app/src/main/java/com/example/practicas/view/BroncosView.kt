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
fun BroncosView(navController: NavController) {
    val BroncosOrange = Color(0xFFFB4F14)


    val teamImages = listOf(
        R.drawable.bron,
        R.drawable.bronco,
        R.drawable.bronc,

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Denver Broncos", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.broncos),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BroncosOrange,
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
            Text("Los Denver Broncos fueron fundados como equipo charter de la American " +
                    "Football League (AFL) en 1960. El equipo jugó en el Bears Stadium" +
                    " (que más tarde se convirtió en Mile High Stadium), aunque no ganaron títulos en la AFL," +
                    " se convirtieron en un equipo exitoso después de la fusión AFL-NFL en 1970. Su primera aparición " +
                    "en el Super Bowl fue tras la temporada de 1977 (Super Bowl XII). ")
            Text("Su estadio histórico fue el Mile High Stadium (de 1960 a 2000)," +
                    "")
            Text("Tres títulos de Super Bowl: Super Bowl XXXII (1997), Super Bowl XXXIII " +
                    "(1998) y Super Bowl 50 (2015).")

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