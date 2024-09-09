package com.example.dagger.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dagger.App
import com.example.dagger.R
import com.example.dagger.di.Person1
import com.example.dagger.factory.MainViewModelFactory
import com.example.dagger.fragment.di.DaggerFragment1Component
import com.example.dagger.fragment.di.Person2
import com.example.dagger.fragment.di.Person3
import javax.inject.Inject

class Fragment1 : Fragment(R.layout.fragment_1) {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory<Fragment1ViewModel>

    @Inject
    lateinit var person1: Person1

    @Inject
    lateinit var person2: Person2

    @Inject
    lateinit var person3: Person3

    private val viewModel by viewModels<Fragment1ViewModel> {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as App).fragment1Component
        component.inject(this)
        println(component)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(viewModel)
        println(person1)
        println(person2)
        println(person3)
    }
}