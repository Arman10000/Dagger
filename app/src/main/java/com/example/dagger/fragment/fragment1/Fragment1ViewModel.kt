package com.example.dagger.fragment.fragment1

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dagger.App
import com.example.dagger.di.ApplicationContext
import com.example.dagger.fragment.fragment1.di.Fragment1Component
import javax.inject.Inject

class Fragment1ViewModel @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        val app = (applicationContext as App)
        app.deleteComponentToFragment(Fragment1Component::class.java.simpleName)
    }
}