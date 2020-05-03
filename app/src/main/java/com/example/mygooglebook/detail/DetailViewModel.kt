package com.example.mygooglebook.detail

import com.example.mygooglebook.database.Book
import com.example.mygooglebook.remote.ApiRepository
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit


class DetailViewModel private constructor(
    transformer: (Flowable<Book>) -> Publisher<String>
): DetailSaveViewModel<Book>(transform = transformer) {
    companion object{
        operator fun invoke(api : ApiRepository): DetailViewModel = DetailViewModel{
            it.debounce(400, TimeUnit.MICROSECONDS)
                .switchMap { handler(api,it) }
                .distinctUntilChanged()
        }

        private fun handler(
            api: ApiRepository,
            book: Book
        ): Flowable<String> =
            api.insertData(book).toFlowable()
    }
}