package com.example.pregnancyvitalstracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.example.pregnancyvitalstracker.data.AppDatabase
import com.example.pregnancyvitalstracker.data.VitalsEntity


class VitalsViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).vitalsDao()

    val vitalsList = dao.getAllVitals()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addVitals(sys: Int, dia: Int, heart: Int, weight: Int, kicks: Int) {
        viewModelScope.launch {
            dao.insertVitals(
                VitalsEntity(
                    systolic = sys,
                    diastolic = dia,
                    heartRate = heart,
                    weight = weight,
                    kicks = kicks
                )
            )
        }
    }
}
