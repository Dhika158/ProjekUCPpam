package com.example.projekpam.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projekpam.ui.screens.DashboardScreen
import com.example.projekpam.ui.screens.PlaceholderScreen
import com.example.projekpam.ui.screens.WelcomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    val goBack: () -> Unit = { navController.popBackStack() }

    val goToDashboard: () -> Unit = {
        navController.navigate(ScreenRoutes.DASHBOARD) {
            popUpTo(ScreenRoutes.WELCOME) { inclusive = true }
        }
    }

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.WELCOME
    ) {
        composable(ScreenRoutes.WELCOME) {
            WelcomeScreen(
                onLoginClick = { navController.navigate(ScreenRoutes.LOGIN) },
                onRegisterClick = { navController.navigate(ScreenRoutes.REGISTER) }
            )
        }

        // Sementara: diganti LoginScreen asli pada Tahap 4
        composable(ScreenRoutes.LOGIN) {
            PlaceholderScreen(title = "Login", onBack = goBack) {
                Button(onClick = goToDashboard) { Text("Masuk (sementara)") }
            }
        }

        // Sementara: diganti RegisterScreen asli pada Tahap 4
        composable(ScreenRoutes.REGISTER) {
            PlaceholderScreen(title = "Register", onBack = goBack) {
                Button(onClick = {
                    navController.navigate(ScreenRoutes.LOGIN) {
                        popUpTo(ScreenRoutes.REGISTER) { inclusive = true }
                    }
                }) { Text("Daftar (sementara)") }
            }
        }

        composable(ScreenRoutes.DASHBOARD) {
            DashboardScreen(
                onNavigate = { route -> navController.navigate(route) },
                onLogout = {
                    navController.navigate(ScreenRoutes.WELCOME) {
                        popUpTo(ScreenRoutes.DASHBOARD) { inclusive = true }
                    }
                }
            )
        }

        // Layar modul: diganti satu per satu pada Tahap 5-7
        val modules = listOf(
            ScreenRoutes.SEMESTER to "Semester",
            ScreenRoutes.COURSE to "Mata Kuliah",
            ScreenRoutes.SCHEDULE to "Jadwal",
            ScreenRoutes.TASK to "Tugas",
            ScreenRoutes.NOTE to "Catatan",
            ScreenRoutes.ANNOUNCEMENT to "Info Kelas",
            ScreenRoutes.FILE_STORAGE to "Berkas Lokal"
        )
        modules.forEach { (route, title) ->
            composable(route) {
                PlaceholderScreen(title = title, onBack = goBack)
            }
        }
    }
}