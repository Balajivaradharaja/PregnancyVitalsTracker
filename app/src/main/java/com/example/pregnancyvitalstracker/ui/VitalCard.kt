package com.example.pregnancyvitalstracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancyvitalstracker.data.VitalsEntity
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun VitalCard(v: VitalsEntity) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1C6F3))
    ) {
        Column {

            // Main content
            Column(modifier = Modifier.padding(16.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalItem("❤️", "${v.heartRate} bpm")
                    VitalItem("🩸", "${v.systolic}/${v.diastolic} mmHg")
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalItem("⚖️", "${v.weight} kg")
                    VitalItem("👶", "${v.kicks} kicks")
                }
            }

            // Bottom date bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF9C4DCC))
                    .padding(vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = formatDate(v.time),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun VitalItem(icon: String, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = icon, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

fun formatDate(time: Long): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault())
    return sdf.format(Date(time))
}
