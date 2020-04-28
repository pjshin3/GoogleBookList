package com.example.mygooglebook.bind

import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter
import com.arlib.floatingsearchview.FloatingSearchView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.textfield.TextInputLayout

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
fun FloatingSearchView.listnerTextOnChange(listner : FloatingSearchView.OnQueryChangeListener) = setOnQueryChangeListener(listner)