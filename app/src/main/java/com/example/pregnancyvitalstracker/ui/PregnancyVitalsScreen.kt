package com.example.pregnancyvitalstracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancyvitalstracker.viewmodel.VitalsViewModel
import com.example.pregnancyvitalstracker.data.VitalsEntity

@Composable
fun PregnancyVitalsScreen(viewModel: VitalsViewModel) {

    val vitalsList by viewModel.vitalsList.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFF9C4DCC)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F2FB))
                .padding(padding)
        ) {

            // Top Header
            Text(
                text = "Track My Pregnancy",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE6CFF2))
                    .padding(16.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(vitalsList) { vitals ->
                    VitalCard(vitals)
                }
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(
            onSubmit = { s, d, h, w, k ->
                viewModel.addVitals(s, d, h, w, k)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}

