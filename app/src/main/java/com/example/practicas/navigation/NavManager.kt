package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practicas.view.*
import com.example.practicas.view.SplashScreen

@Composable
fun NavManager(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen { navController.navigate("home") }
        }
        composable("home") { HomeView(navController) }
        composable("americana") { AmericanaView(navController) }
        composable("nacional") { NacionalView(navController) }

        // Americana
        composable("dolphins") { DolphinsView(navController) }
        composable("broncos") { BroncosView(navController) }
        composable("jaguars") { JaguarsView(navController) }
        composable("ravens") { RavensView(navController) }

        // Nacional
        composable("bears") { BearsView(navController) }
        composable("cowboys") { CowboysView(navController) }

        composable("arizona") { ArizonaView(navController) }
        composable("eagles") { EaglesView(navController) }
    }
}

