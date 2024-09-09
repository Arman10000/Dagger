package com.example.dagger.fragment.di

import com.example.dagger.di.AppComponent
import com.example.dagger.fragment.Fragment1
import dagger.Component
import javax.inject.Scope

@Fragment1Scope
@Component(dependencies = [AppComponent::class], modules = [Fragment1Module::class])
interface Fragment1Component {
    fun inject(fragment: Fragment1)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): Fragment1Component
    }
}