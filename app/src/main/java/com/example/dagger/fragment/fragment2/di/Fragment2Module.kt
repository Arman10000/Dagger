package com.example.dagger.fragment.fragment2.di

import dagger.Module
import dagger.Provides

class Person4
class Person5

@Module
class Fragment2Module {

    @Fragment2Scope
    @Provides
    fun person4(): Person4 = Person4()

    @Provides
    fun person5(): Person5 = Person5()
}