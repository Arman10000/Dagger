package com.example.dagger.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

class Person1

@Module
class AppModule {
    @Singleton
    @Provides
    fun person1(): Person1 = Person1()

}

//interface Person
//class Person3 @Inject constructor() : Person
//
//abstract class Module {
//    @Binds
//    abstract fun person(person3: Person3): Person
//}