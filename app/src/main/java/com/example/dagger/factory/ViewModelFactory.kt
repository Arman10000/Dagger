package com.example.dagger.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModel: VM
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}

inline fun <reified VM : ViewModel> Fragment.assistedViewModels(
    crossinline viewModelProducer: (handle: SavedStateHandle) -> VM
): Lazy<VM> = viewModels<VM> {
    @Suppress("UNCHECKED_CAST")
    object : AbstractSavedStateViewModelFactory() {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T = viewModelProducer(handle) as T
    }
}