package com.example.dagger.activity.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ActivityComponent {
    @ActivityContext
    fun activityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@ActivityContext @BindsInstance activityContext: Context): ActivityComponent
    }

}