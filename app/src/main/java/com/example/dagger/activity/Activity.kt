package com.example.dagger.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.App
import com.example.dagger.R
import com.example.dagger.activity.di.DaggerActivityComponent
import com.example.dagger.fragment.fragment1.Fragment1

class Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            (application as App).activityComponent = DaggerActivityComponent.factory().create(this)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, Fragment1.newInstance())
                .commit()
        }
    }
}

