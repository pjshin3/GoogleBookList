package com.example.mygooglebook.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.databinding.FragmentBookDetailBinding
import com.example.mygooglebook.delegate.DetailDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment(){

    private val arg : DetailFragmentArgs by navArgs()
    private val detailViewModel by viewModel<DetailViewModel> { parametersOf(this.context!!.applicationContext) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        with(detailViewModel){
            book.value = genarateBoo()
        }

        val bindig = FragmentBookDetailBinding.inflate(inflater,container,false).also {
            it.delegate = DetailDelegate(
                detailViewModel
            )
        }

        return bindig.root
    }

    fun genarateBoo() = Book(
        bookId = 0,
        title = arg.title,
        imageUrl = arg.imageUrl,
        ahtor = "",
        description = arg.Description
    )
}