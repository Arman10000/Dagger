package com.example.dagger.fragment.fragment1.di

import com.example.dagger.activity.di.ActivityComponent
import com.example.dagger.di.AppComponent
import com.example.dagger.fragment.fragment1.Fragment1
import dagger.Component

@Fragment1Scope
@Component(
    dependencies = [AppComponent::class, ActivityComponent::class],
    modules = [Fragment1Module::class]
)
interface Fragment1Component {
    fun inject(fragment: Fragment1)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            activityComponent: ActivityComponent
        ): Fragment1Component
    }
}