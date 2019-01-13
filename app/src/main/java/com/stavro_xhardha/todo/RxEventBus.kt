package com.stavro_xhardha.todo

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxEventBus {
    companion object {
        val publisher: PublishSubject<Any> = PublishSubject.create()

        inline fun <reified T> subscribe(): Observable<T> {
            return publisher.ofType(T::class.java)
        }

        fun publish(event: Any) {
            publisher.onNext(event)
        }
    }
}