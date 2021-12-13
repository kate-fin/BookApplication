package com.example.bookapplication

import dagger.Component

@Component(modules = [Bag::class])
interface MagicBox /*SomeComponent*/{
    fun poke(app: MainActivity)//inject
}