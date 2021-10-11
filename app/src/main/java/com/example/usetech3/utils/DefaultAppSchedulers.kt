package com.example.usetech3.utils

import android.os.Looper
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DefaultAppSchedulers : AppSchedulers {
  override val io: Scheduler get() = Schedulers.io()
  override val computation: Scheduler get() = Schedulers.computation()
  override val ui: Scheduler get() = AndroidSchedulers.mainThread()

  override fun checkMainThread() {
    check(
      Looper.getMainLooper() == Looper.myLooper()
    ) { "Expected to be called on main thread but was ${Thread.currentThread().name}" }
  }

  override fun checkBackgroundThread() {
    check(
      Looper.getMainLooper() != Looper.myLooper()
    ) { "Expected to be called on background thread but was ${Thread.currentThread().name}" }
  }
}
