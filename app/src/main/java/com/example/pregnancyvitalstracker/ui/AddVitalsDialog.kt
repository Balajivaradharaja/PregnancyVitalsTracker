package com.example.pregnancyvitalstracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddVitalsDialog(
    onSubmit: (Int, Int, Int, Int, Int) -> Unit,
    onDismiss: () -> Unit
) {
    var sys by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var heart by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Add Vitals", style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(sys, { sys = it }, label = { Text("Sys BP") })
                OutlinedTextField(dia, { dia = it }, label = { Text("Dia BP") })
                OutlinedTextField(heart, { heart = it }, label = { Text("Heart Rate") })
                OutlinedTextField(weight, { weight = it }, label = { Text("Weight (kg)") })
                OutlinedTextField(kicks, { kicks = it }, label = { Text("Baby Kicks") })

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onSubmit(
                            sys.toInt(),
                            dia.toInt(),
                            heart.toInt(),
                            weight.toInt(),
                            kicks.toInt()
                        )
                    }
                ) {
                    Text("Submit")
                }
            }
        }
    }
}
