package com.example.dagger

import android.app.Application
import com.example.dagger.activity.di.ActivityComponent
import com.example.dagger.di.DaggerAppComponent

class App : Application() {

    val appComponent = DaggerAppComponent.factory().create(this)

    lateinit var activityComponent: ActivityComponent

    private val components = mutableMapOf<String, Any>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getComponentToFragment(
        simpleName: String,
        componentProvider: () -> T
    ): T {
        var component = components[simpleName] as? T
        if (component == null) {
            component = componentProvider()
            components[simpleName] = component
        }
        return component
    }

    fun deleteComponentToFragment(simpleName: String) {
        components.remove(simpleName)
    }

}