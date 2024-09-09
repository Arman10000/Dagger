package com.example.dagger

import android.app.Application
import com.example.dagger.di.DaggerAppComponent
import com.example.dagger.fragment.di.DaggerFragment1Component
import com.example.dagger.fragment.di.Fragment1Component

class App : Application() {

    private val components = mutableMapOf<String, Any>()

    val appComponent = DaggerAppComponent.factory().create(this)

    val fragment1Component: Fragment1Component
        get() {
            var component = components[Fragment1Component::class.java.simpleName] as? Fragment1Component
            if (component == null) {
                component = DaggerFragment1Component.factory().create(appComponent)
                components[Fragment1Component::class.java.simpleName] = component
            }
            return component
        }

    fun deleteFragment1Component() {
        components.remove(Fragment1Component::class.java.simpleName)
    }

}