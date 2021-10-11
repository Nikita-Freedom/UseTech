package com.example.usetech3.utils

import io.reactivex.Scheduler

interface AppSchedulers {
    val io: Scheduler
    val computation: Scheduler
    val ui: Scheduler

    fun checkMainThread()
    fun checkBackgroundThread()
}
