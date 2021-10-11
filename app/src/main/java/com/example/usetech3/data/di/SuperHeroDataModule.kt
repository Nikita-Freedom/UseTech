package com.example.usetech3.data.di

import com.example.usetech3.data.SuperheroRepositoryImpl
import com.example.usetech3.domain.SuperHeroRepository
import toothpick.config.Module

class SuperHeroDataModule: Module() {
    init {
        bind(SuperHeroRepository::class.java)
            .to(SuperheroRepositoryImpl::class.java)
            .singletonInScope()

    }
}