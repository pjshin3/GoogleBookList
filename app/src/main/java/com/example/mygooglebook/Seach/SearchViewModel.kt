package com.example.mygooglebook.Seach

import com.example.mygooglebook.remote.SeachRepository
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit


class SearchViewModel private constructor(
    transform : (Flowable<String>) -> Publisher<QueryViewState<String>>
) : QueryViewModel<String>(transform){
    companion object{
        operator fun invoke(api : SeachRepository) : SearchViewModel = SearchViewModel {
            it.debounce(400, TimeUnit.MICROSECONDS)
                .switchMap { query -> handler(query,api)}
                .startWith(QueryViewState.idel())
            }
        private fun handler(
            query : String,
            api : SeachRepository)
                : Flowable<QueryViewState<String>> =
            if (query.isEmpty()){
                Flowable.just(QueryViewState.idel())
            }else{
                search(query,api)
            }

        private fun search(
            query: String,
            api: SeachRepository
        ): Flowable<QueryViewState<String>> =
            api.searchBookList(query).toFlowable()
                .map { it.toViewState() }
                .startWith(QueryViewState.loading())
    }
}