package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NacionalView(navController: NavController) {
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("NFC", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF3F51B5)

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
        ContenidoNfcView(navController)
        Spacer(modifier = Modifier.height(20.dp))
    }
}
@Composable
fun ContenidoNfcView(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            TeamCard(
                navController = navController,
                teamName = "Bears",
                destination = "bears",
                imageResId = R.drawable.bears,

            )
            TeamCard(
                navController = navController,
                teamName = "Cowboys",
                destination = "cowboys",
                imageResId = R.drawable.cowboys,

            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f)
        ) {
            TeamCard(
                navController = navController,
                teamName = "Arizona Cardinals",
                destination = "arizona",
                imageResId = R.drawable.arizona,

            )
            TeamCard(
                navController = navController,
                teamName = "Eagles",
                destination = "eagles",
                imageResId = R.drawable.eagles,

            )
        }
    }
}


@Composable
fun RowScope.Card(
    navController: NavController,
    teamName: String,
    destination: String,
    imageResId: Int,

) {

    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .padding(8.dp)
            .clickable { navController.navigate(destination) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = teamName,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
        )


        Text(
            text = teamName,
            style = MaterialTheme.typography.titleMedium,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))


        Button(onClick = { navController.navigate(destination) }) {
            Text(text = "View")
        }
    }
}