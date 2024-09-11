package com.example.dagger.fragment.fragment2

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.dagger.App
import com.example.dagger.di.ApplicationContext
import com.example.dagger.fragment.fragment2.di.Fragment2Component
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class Fragment2ViewModel @AssistedInject constructor(
    @ApplicationContext private val applicationContext: Context,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        println(savedStateHandle.get<Int>("key"))
    }

    override fun onCleared() {
        super.onCleared()
        val app = (applicationContext as App)
        app.deleteComponentToFragment(Fragment2Component::class.java.simpleName)
    }

    @AssistedFactory
    interface Factory {

        fun create(
            handle: SavedStateHandle
        ): Fragment2ViewModel
    }
}