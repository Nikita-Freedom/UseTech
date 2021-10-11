package com.example.usetech3.domain

import com.example.usetech3.data.entity.responses.IdResponse
import com.example.usetech3.data.entity.responses.NameResponse
import io.reactivex.Single

interface SuperHeroRepository{
    fun getById(id: String): Single<IdResponse>
    fun getByName(name: String):  Single<NameResponse>
}