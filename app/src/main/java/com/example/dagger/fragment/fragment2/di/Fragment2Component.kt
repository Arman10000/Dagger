package com.example.dagger.fragment.fragment2.di

import com.example.dagger.di.AppComponent
import com.example.dagger.fragment.fragment2.Fragment2
import dagger.Component

@Fragment2Scope
@Component(dependencies = [AppComponent::class], modules = [Fragment2Module::class])
interface Fragment2Component {
    fun inject(fragment: Fragment2)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): Fragment2Component
    }
}