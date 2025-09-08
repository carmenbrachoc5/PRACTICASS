package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.model.content.RectangleShape
import com.example.practicas.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AmericanaView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("AFC", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF8F0404)
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContenidoAfcView(navController)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun ContenidoAfcView(navController: NavController) {
    Column(

        modifier = Modifier.fillMaxSize()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f)
                .padding(8.dp)
        ) {
            TeamCard(
                navController = navController,
                teamName = "Miami Dolphins",
                destination = "dolphins",
                imageResId = R.drawable.dolphins
            )
            TeamCard(
                navController = navController,
                teamName = "Denver Broncos",
                destination = "broncos",
                imageResId = R.drawable.broncos
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f)
                .padding(8.dp)
        ) {
            TeamCard(
                navController = navController,
                teamName = "Jacksonville Jaguars",
                destination = "jaguars",
                imageResId = R.drawable.jaguars
            )
            TeamCard(
                navController = navController,
                teamName = "Baltimore Ravens",
                destination = "ravens",
                imageResId = R.drawable.ravens
            )
        }
    }
}

@Composable
fun RowScope.TeamCard(
    navController: NavController,
    teamName: String,
    destination: String,
    imageResId: Int
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .padding(8.dp)
            .clickable { navController.navigate(destination) },
        shape = RectangleShape,
        border = BorderStroke(2.dp, Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = teamName,
                modifier = Modifier.size(140.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = teamName,
                style = MaterialTheme.typography.titleMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}
