package com.example.mygooglebook.Seach

import com.example.mygooglebook.remote.SeachRepository
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

class SuggestionViewModel private constructor(
    transform: (Flowable<String>) -> Publisher<QueryViewState<String>>
) : QueryViewModel<String>(transform){

    companion object{

        operator fun invoke(api : SeachRepository) : SuggestionViewModel = SuggestionViewModel{
            it.debounce(400, TimeUnit.MICROSECONDS)
                .switchMap { query -> handleQuery(query,api) }
                .startWith( QueryViewState.idel() )
                .distinctUntilChanged()
        }

        private fun handleQuery(
            query : String,
            api : SeachRepository
        ): Flowable<QueryViewState<String>> =
            if (query.isEmpty()){
                Flowable.just(QueryViewState.idel())
            }else{
                searchSuggestions(query,api)
            }

        private fun searchSuggestions(
            query: String,
            api : SeachRepository
        ): Flowable<QueryViewState<String>> =
            api.searchSuggestion(query).toFlowable()
                .map { it.toViewState() }
                .startWith(QueryViewState.loading())

    }
}