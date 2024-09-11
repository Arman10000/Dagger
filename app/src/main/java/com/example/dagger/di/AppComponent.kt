package com.example.dagger.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @ApplicationContext
    fun applicationContext(): Context
    fun person1(): Person1

    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance applicationContext: Context): AppComponent
    }
}