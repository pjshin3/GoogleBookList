package com.example.mygooglebook.bind

import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.mygooglebook.List.BookListAdapter
import com.example.mygooglebook.Seach.*
import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.util.toHumanResponse
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_book_detail.view.*

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view:ImageView, imageUrl: String?){
    if (!imageUrl.isNullOrEmpty()){
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: View,isGone: Boolean){
    view.visibility = if (isGone){
        View.GONE
    }else{
        View.VISIBLE
    }
}

@BindingAdapter("on_change")
fun FloatingSearchView.listnerTextOnChange(
        listner : FloatingSearchView.OnQueryChangeListener
): Unit = setOnQueryChangeListener(listner)

@BindingAdapter("state_change")
fun FloatingSearchView.bindSuggestion(data: QueryViewState<String>?): Unit? = data?.let { state ->
    toggleProgress(state.Loading)
    state.error.fold({
        state.Result.map { QuerySearchSuggestion.ResultSuggestion(it) }
    },{
        listOf(QuerySearchSuggestion.ErrorSuggestion(it.toHumanResponse()))
    }).let { swapSuggestions(it) }
}

private fun FloatingSearchView.toggleProgress(show: Boolean): Unit = when(show){
    true -> showProgress()
    false -> hideProgress()
}

interface ClickConsumer : Consumer<SearchSuggestion>
interface SearchConsumer : Consumer<String>

@BindingAdapter("on_suggestion_click","on_search",requireAll = false)
fun FloatingSearchView.bindSuggestionClick(clickConsumer: ClickConsumer?,searchConsumer: SearchConsumer?){
    setOnSearchListener(object : FloatingSearchView.OnSearchListener{
        override fun onSearchAction(currentQuery: String?) {
            searchConsumer?.apply { searchConsumer.accept(currentQuery) }
        }

        override fun onSuggestionClicked(searchSuggestion: SearchSuggestion?) {
            clickConsumer?.apply {
                when(searchSuggestion){
                    is QuerySearchSuggestion.ResultSuggestion -> {
                        clickConsumer.accept(searchSuggestion)
                        setSearchFocused(false)
                    }
                }
            }
        }
    })
}

fun View.gone(gone:Boolean) = with(this){
    visibility = when(gone){
        true -> View.GONE
        false -> View.VISIBLE
    }
}

@BindingAdapter("adapter","state_change",requireAll = false)
fun RecyclerView.bindStateData(inputAdapter: BookListAdapter,data:QueryViewState<Items>?){
    if (adapter == null){
        adapter = inputAdapter
    }

    data?.let {
        bindError(data.hasError)
        bindResult(data.Result)
    }
}

@BindingAdapter("state_change")
fun ProgressBar.bindState(data:QueryViewState<Items>?) = data?.let {
    gone(!it.Loading)
}
private fun RecyclerView.bindError(error: Boolean): Unit =
    gone(error)

private fun RecyclerView.bindResult(reulst: List<Items>): Unit =
    with(adapter as BookListAdapter){
        this.submitList(reulst)
    }

@BindingAdapter("on_click")
fun FloatingActionButton.bindOnClick(onClickListener: View.OnClickListener) =
    setOnClickListener(onClickListener)