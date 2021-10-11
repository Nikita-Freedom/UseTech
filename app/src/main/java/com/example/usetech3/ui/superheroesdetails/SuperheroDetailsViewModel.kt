package com.example.usetech3.ui.superheroesdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usetech3.data.SuperheroRepositoryImpl
import com.example.usetech3.data.entity.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SuperheroDetailsViewModel @Inject constructor(
    //private val repository: SuperHeroRepository
) : ViewModel() {
    private val repository = SuperheroRepositoryImpl()
    var superhero = MutableLiveData<Result>()
    fun getSuperhero(id: Int): Disposable? {
        return repository.getById(id.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                superhero.postValue(
                    Result(
                        it.id,
                        it.name,
                        it.powerStats,
                        it.biography,
                        it.appearance,
                        it.work,
                        it.connections,
                        it.image
                    )
                )
            }
            .subscribe()

    }

}