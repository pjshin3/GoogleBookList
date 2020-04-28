package com.example.mygooglebook.Seach

import com.example.mygooglebook.remote.Repository
import com.example.mygooglebook.remote.data.ResponseBookData
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

class SeachViewModel private constructor(
    transform : (Flowable<String>) -> Publisher<QueryViewState<ResponseBookData>>
) : QueryViewModel<String>(transform){

    companion object{
        operator fun invoke(api : Repository) : SeachViewModel = SeachViewModel {
            it.debounce(400,TimeUnit.MICROSECONDS)
                .switchMap { query -> handleQuery(query,api) }
                .startWith{ QueryViewState.idel() }
                .distinctUntilChanged()
        }

        private fun handleQuery(
            query: String,
            api : Repository
        ): Flowable<QueryViewState<String>> =
            if (query.isEmpty()){
                Flowable.just(QueryViewState.idel())
            }else{
                searchItem(query,api)
                    .flatMapPublisher {  }
            }

        private fun searchItem(
            query: String,
            api: Repository
        ): Single<List<String>> =
            api.getBookList(genarateSerchParams(query))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    it.items.distinctBy {
                        it.volumeInfo.title
                    }
                        .map { it.volumeInfo.title }
                }


        private fun genarateSerchParams(world : String) : Map<String,String>{
            val param = mutableMapOf<String,String>()
            with(param){
                put("q",world)
                put("oderBy","newest")
                put("key","AIzaSyC1gWxwOTOlanFaEl4nGgSz6goRRhYKZbo")
            }
            return param
        }
    }


//    private val _result = MutableLiveData<ResponseBookData>()
//    val result : LiveData<ResponseBookData>
//        get() = _result






//    @SuppressLint("CheckResult")
//    fun seachBookStart(world : String){
//        seachRepository.getBookList(genarateSerchParams(world))
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//            _result.postValue(it)
//        },{
//            throw it
//        })
//    }
//
}