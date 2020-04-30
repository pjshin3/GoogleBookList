package com.example.mygooglebook.Seach

import arrow.core.Either
import com.example.mygooglebook.remote.SeachRepository
import com.example.mygooglebook.remote.data.BookError
import io.reactivex.Flowable
import io.reactivex.Observable
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

class SeachViewModel private constructor(
    transform: (Flowable<String>) -> Publisher<QueryViewState<String>>
) : QueryViewModel<String>(transform){

    companion object{
//        operator fun invoke(api : SeachRepository) : SeachViewModel = SeachViewModel {
////            it.debounce(400,TimeUnit.MICROSECONDS)
////                .switchMap { query -> handleQuery(query,api)}
////                .startWith(QueryViewState.idel())
////                .distinctUntilChanged()
//        }

        operator fun invoke(api : SeachRepository) : SeachViewModel = SeachViewModel{
            it.debounce(400, TimeUnit.MICROSECONDS)
                .switchMap { query -> handleQuery(query,api) }
                .startWith( QueryViewState.idel() )
        }

        private fun test() : Flowable<QueryViewState<String>> = Flowable.just(QueryViewState.loading())

        private fun handleQuery(
            query : String,
            api : SeachRepository
        ): Flowable<QueryViewState<String>> =
            if (query.isEmpty()){
                Flowable.just(QueryViewState.idel())
            }else{
                Flowable.just(QueryViewState.loading())
            }

        private fun searchSuggestions(
            query: String,
            api : SeachRepository
        ): Flowable<QueryViewState<String>> =
            api.find(query).toFlowable()
                .map { it.toViewState() }
                .startWith(QueryViewState.loading())

    }
}