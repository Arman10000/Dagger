package com.example.dagger.fragment.fragment2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.dagger.App
import com.example.dagger.R
import com.example.dagger.di.Person1
import com.example.dagger.factory.assistedViewModels
import com.example.dagger.fragment.fragment2.di.DaggerFragment2Component
import com.example.dagger.fragment.fragment2.di.Fragment2Component
import com.example.dagger.fragment.fragment2.di.Person4
import com.example.dagger.fragment.fragment2.di.Person5
import javax.inject.Inject

class Fragment2 : Fragment(R.layout.fragment_2) {

    @Inject
    lateinit var person1: Person1

    @Inject
    lateinit var person4: Person4

    @Inject
    lateinit var person5: Person5

    @Inject
    lateinit var viewModelFactory: Fragment2ViewModel.Factory

    private val viewModel: Fragment2ViewModel by assistedViewModels {
        viewModelFactory.create(it)
    }

    private val component: Fragment2Component
        get() {
            val app = (requireActivity().application as App)
            return app.getComponentToFragment(Fragment2Component::class.java.simpleName) {
                DaggerFragment2Component.factory().create(
                    app.appComponent
                )
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(viewModel)
        println(component)
    }

    companion object {
        fun newInstance() = Fragment2()
    }
}