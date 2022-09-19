package com.example.indianjokesapplication.joke_api

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.indianjokesapplication.R

@BindingAdapter("setStatusImage")
fun ImageView.setStatusImage (status: Status){
    when(status){
        Status.LOADING -> {
            this.visibility = View.VISIBLE
            this.setImageResource(R.drawable.loading_animation)
        }
        Status.FAIL ->{
            this.visibility = View.VISIBLE
            this.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {
            this.visibility = View.GONE
        }
    }
}