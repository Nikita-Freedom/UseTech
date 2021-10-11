package com.example.usetech3.di

import com.example.usetech3.utils.AppSchedulers
import com.example.usetech3.utils.DefaultAppSchedulers
import toothpick.config.Module

class AppModule: Module() {
    init {
    bind(AppSchedulers::class.java).toInstance(DefaultAppSchedulers)
    }
}