package com.example.mygooglebook.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mygooglebook.MyBookList.MyBookListViewModel
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.databinding.FragmentBookDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment(){

   private val arg : DetailFragmentArgs by navArgs()
   private val myBookListViewModel : MyBookListViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindig = FragmentBookDetailBinding.inflate(inflater,container,false)

        val detailViewModel = DetailViewModelFactory(
            title = arg.title,
            imageUrl = arg.imageUrl,
            description = arg.Description)
            .create(DetailViewModel::class.java)

        bindig.viewmodel = detailViewModel

        bindig.addActionbutton.setOnClickListener {
            insetToDatabase()
        }

        return bindig.root
    }

    fun insetToDatabase(){
        myBookListViewModel.inset(genarateBook())
    }

    fun genarateBook(): Book{
        val book = Book(
            title = arg.title,
            imageUrl = arg.imageUrl,
            ahtor = "",
            description = "",
            bookId = arg.title
        )
        return book
    }
}