package com.example.usetech3.data

import android.annotation.SuppressLint

import com.example.usetech3.data.entity.responses.IdResponse
import com.example.usetech3.data.entity.responses.NameResponse
import com.example.usetech3.domain.SuperHeroRepository
import com.example.usetech3.network.ApiService.userApi
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class SuperheroRepositoryImpl @Inject constructor (
//    private val userApi: SuperHeroApi,
//    private val schedulers: AppSchedulers,
): SuperHeroRepository {

    @SuppressLint("CheckResult")
    override fun getById(id: String): Single<IdResponse> {
        return  Single.create { emitter ->
            userApi.getById(id).subscribe ({ response ->
               // schedulers.checkBackgroundThread()
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            },
                {
                    emitter.onError(it)
                })
        }
    }

    @SuppressLint("CheckResult")
    override fun getByName(name: String): Single<NameResponse> {
        return  Single.create { emitter ->
            userApi.getByName(name).subscribe ({ response ->
               // schedulers.checkBackgroundThread()
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            },
                {
                    emitter.onError(it)
                })
        }
    }
}