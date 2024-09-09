package com.example.dagger.di

import android.content.Context
import com.example.dagger.MainActivity
import com.example.dagger.fragment.Fragment1
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun applicationContext(): Context
    fun person1(): Person1

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}