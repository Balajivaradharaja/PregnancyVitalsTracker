package com.example.pregnancyvitalstracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class VitalsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val systolic: Int,
    val diastolic: Int,
    val heartRate: Int,
    val weight: Int,
    val kicks: Int,
    val time: Long = System.currentTimeMillis()
)
