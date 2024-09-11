package com.example.dagger.fragment.fragment1.di

import android.content.Context
import com.example.dagger.activity.di.ActivityContext
import dagger.Module
import dagger.Provides

class Person2
class Person3(activityContext: Context)

@Module
class Fragment1Module {

    @Fragment1Scope
    @Provides
    fun person2(): Person2 = Person2()

    @Provides
    fun person3(
        @ActivityContext activityContext: Context
    ): Person3 = Person3(activityContext)

}