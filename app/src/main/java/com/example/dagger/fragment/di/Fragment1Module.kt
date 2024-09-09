package com.example.dagger.fragment.di

import dagger.Module
import dagger.Provides

class Person2

class Person3

@Module
class Fragment1Module {

    @Fragment1Scope
    @Provides
    fun person2(): Person2 = Person2()

    @Provides
    fun person3(): Person3 = Person3()
}