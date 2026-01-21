package com.example.pregnancyvitalstracker

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.pregnancyvitalstracker.ui.PregnancyVitalsScreen
import com.example.pregnancyvitalstracker.viewmodel.VitalsViewModel
import com.example.pregnancyvitalstracker.worker.ReminderWorker
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                101
            )
        }

        val workRequest =
            PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "VitalsReminder",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[VitalsViewModel::class.java]

        setContent {
            PregnancyVitalsScreen(viewModel)
        }
    }
}


