package com.example.dagger

import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val applicationContext: Context
) : ViewModel()