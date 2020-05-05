package com.example.mygooglebook.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mygooglebook.BaseFragment
import com.example.mygooglebook.R
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.databinding.FragmentBookDetailBinding
import com.example.mygooglebook.delegate.DetailDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment
    : BaseFragment<FragmentBookDetailBinding>(R.layout.fragment_book_detail){

    private val arg : DetailFragmentArgs by navArgs()
    private val detailViewModel by viewModel<DetailViewModel> { parametersOf(this.context!!.applicationContext) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(detailViewModel){
            book.value = genarateBook()
        }

        with(bindig){
            delegate = DetailDelegate( detailViewModel )
        }
    }

    fun genarateBook() = Book(
        bookId = 0,
        title = arg.title,
        imageUrl = arg.imageUrl,
        ahtor = "",
        description = arg.Description
    )
}