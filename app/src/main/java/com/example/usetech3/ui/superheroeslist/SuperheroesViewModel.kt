package com.example.usetech3.ui.superheroeslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usetech3.data.SuperheroRepositoryImpl
import com.example.usetech3.data.entity.Result
import com.example.usetech3.data.entity.responses.NameResponse
import com.example.usetech3.domain.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SuperheroesViewModel @Inject constructor(
    //private val repository: SuperHeroRepository
) : ViewModel() {
    val superheroes = MutableLiveData(arrayListOf<Result>())
    val repository = SuperheroRepositoryImpl()

    init {
        Timber.d("init ViewModel")
    }


    fun getSuperheroes(name: String): Disposable? {
        return repository.getByName("search/${name}")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                parseRes(it)
            }
            .doOnError {
                superheroes.postValue(null)
            }
            .subscribe()

    }

    private fun parseRes(result: NameResponse) {
        superheroes.postValue(result.results as ArrayList<Result>?)
    }
}