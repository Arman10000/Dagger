package com.example.dagger.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dagger.App
import javax.inject.Inject

class Fragment1ViewModel @Inject constructor(
    private val applicationContext: Context
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        (applicationContext as App).deleteFragment1Component()
    }
}