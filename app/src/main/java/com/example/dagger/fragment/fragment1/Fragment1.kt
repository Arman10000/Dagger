package com.example.dagger.fragment.fragment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dagger.App
import com.example.dagger.R
import com.example.dagger.di.Person1
import com.example.dagger.factory.ViewModelFactory
import com.example.dagger.fragment.fragment1.di.DaggerFragment1Component
import com.example.dagger.fragment.fragment1.di.Fragment1Component
import com.example.dagger.fragment.fragment1.di.Person2
import com.example.dagger.fragment.fragment1.di.Person3
import com.example.dagger.fragment.fragment2.Fragment2
import javax.inject.Inject

class Fragment1 : Fragment(R.layout.fragment_1) {

    @Inject
    lateinit var person1: Person1

    @Inject
    lateinit var person2: Person2

    @Inject
    lateinit var person3: Person3

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<Fragment1ViewModel>

    private val viewModel: Fragment1ViewModel by viewModels {
        viewModelFactory
    }

    private val component: Fragment1Component
        get() {
            val app = (requireActivity().application as App)
            return app.getComponentToFragment(Fragment1Component::class.java.simpleName) {
                DaggerFragment1Component.factory().create(
                    app.appComponent,
                    app.activityComponent
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

        requireActivity().findViewById<Button>(R.id.button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainerView, Fragment2.newInstance())
                .commit()
        }
    }

    companion object {
        fun newInstance() = Fragment1()
    }
}