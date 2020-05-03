package com.example.mygooglebook.Seach

import com.example.mygooglebook.remote.ApiRepository
import com.example.mygooglebook.remote.data.Items
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit


class SearchViewModel private constructor(
    transform : (Flowable<String>) -> Publisher<QueryViewState<Items>>
) : QueryViewModel<Items>(transform){
    companion object{
        operator fun invoke(api : ApiRepository) : SearchViewModel = SearchViewModel {
            it.debounce(400, TimeUnit.MICROSECONDS)
                .switchMap { query -> handler(query,api)}
                .startWith(QueryViewState.idel())
                .distinctUntilChanged()
            }
        private fun handler(
            query : String,
            api : ApiRepository)
                : Flowable<QueryViewState<Items>> =
            if (query.isEmpty()){
                Flowable.just(QueryViewState.idel())
            }else{
                search(query,api)
            }

        private fun search(
            query: String,
            api: ApiRepository
        ): Flowable<QueryViewState<Items>> =
            api.searchBookList(query).toFlowable()
                .map { it.toViewState() }
                .startWith(QueryViewState.loading())
    }
}