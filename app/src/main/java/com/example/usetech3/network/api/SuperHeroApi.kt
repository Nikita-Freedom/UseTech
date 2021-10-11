package com.example.usetech3.network.api

import com.example.usetech3.data.entity.responses.IdResponse
import com.example.usetech3.data.entity.responses.NameResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface SuperHeroApi {
    @GET
     fun getById(@Url id: String): Single<IdResponse>

    @GET
     fun getByName(@Url name: String): Single<NameResponse>

}