package com.example.module3_1_6.ui

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val count = mutableIntStateOf(0)

    fun increment() {
        count.intValue++
    }
}
