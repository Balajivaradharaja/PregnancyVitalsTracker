package com.example.pregnancyvitalstracker.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancyvitalstracker.NotificationUtils

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        NotificationUtils.showNotification(applicationContext)
        return Result.success()
    }
}