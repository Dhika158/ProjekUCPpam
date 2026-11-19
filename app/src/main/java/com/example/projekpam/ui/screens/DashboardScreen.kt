package com.example.projekpam.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.projekpam.navigation.ScreenRoutes
import com.example.projekpam.ui.components.FeatureCard

private data class MenuItem(
    val icon: ImageVector,
    val title: String,
    val description: String,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit
) {
    val items = listOf(
        MenuItem(Icons.Filled.School, "Semester", "Kelola periode semester", ScreenRoutes.SEMESTER),
        MenuItem(Icons.Filled.MenuBook, "Mata Kuliah", "SKS, dosen, dan nilai", ScreenRoutes.COURSE),
        MenuItem(Icons.Filled.CalendarMonth, "Jadwal", "Jadwal kuliah mingguan", ScreenRoutes.SCHEDULE),
        MenuItem(Icons.Filled.Checklist, "Tugas", "Tugas dan tenggat waktu", ScreenRoutes.TASK),
        MenuItem(Icons.Filled.EditNote, "Catatan", "Ringkasan materi kuliah", ScreenRoutes.NOTE),
        MenuItem(Icons.Filled.Campaign, "Info Kelas", "Pengumuman dari koordinator", ScreenRoutes.ANNOUNCEMENT),
        MenuItem(Icons.Filled.Folder, "Berkas Lokal", "Ekspor dan baca laporan", ScreenRoutes.FILE_STORAGE)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dasbor") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Keluar"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items.forEach { item ->
                FeatureCard(
                    icon = item.icon,
                    title = item.title,
                    description = item.description,
                    modifier = Modifier.clickable { onNavigate(item.route) }
                )
            }
        }
    }
}