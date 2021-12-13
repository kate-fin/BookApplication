package com.example.bookapplication

import dagger.Module
import dagger.Provides

@Module
class Bag {//SomeModule
    @Provides
    open fun sayLoveDagger2(): Info {//providesInfo() - не вызывается в коде
        return Info("Love Dagger 2")
    }
}