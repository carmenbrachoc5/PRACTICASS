package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun ArizonaView(navController: NavController) {
    val CardinalsRed = Color(0xFF97233F)


    val teamImages = listOf(
        R.drawable.bala,
        R.drawable.esta,
        R.drawable.ariz
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Arizona Cardinals", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arizona),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CardinalsRed,
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
            Text("Son la franquicia más antigua de la NFL, fundada en Chicago como Morgan Athletic Club en 1898, " +
                    "ganando campeonatos antes de la era del Super Bowl. El equipo se mudó a St. Louis en 1960 y " +
                    "luego a Phoenix (ahora Arizona) en 1988, renombrándose como Arizona Cardinals en 1994. Su mayor " +
                    "éxito fue llegar al Super Bowl XLIII en la temporada 2008-2009, donde perdieron ante " +
                    "los Pittsburgh Steelers. \n")
            Text("El estadio histórico de los Arizona Cardinals es el Sun Devil Stadium, su hogar de 1988 a 2005," +
                    " mientras que el estadio actual es el State Farm Stadium, inaugurado en 2006 en Glendale.")
            Text("Un título de Conferencia: El equipo ganó el campeonato de la Conferencia Nacional (NFC) en 2008.")


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
                        )
                    }
                }
            }



        }
    }
}