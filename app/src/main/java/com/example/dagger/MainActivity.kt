package com.example.dagger

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.di.Person1
import com.example.dagger.factory.MainViewModelFactory
import com.example.dagger.fragment.Fragment1
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory<MainActivityViewModel>

    private val viewModel by viewModels<MainActivityViewModel> {
        viewModelFactory
    }

    @Inject
    lateinit var person1: Person1

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainerView, Fragment1())
                .commit()
        }

        println(viewModel)
        println(person1)
    }
}