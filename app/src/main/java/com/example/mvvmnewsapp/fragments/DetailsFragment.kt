package com.example.mvvmnewsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mvvmnewsapp.R
import com.example.mvvmnewsapp.databinding.FragmentDetailsBinding
import com.example.mvvmnewsapp.retrofit.response.Article
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val data = requireArguments()["article"] as Article

        binding.articles = data

        Glide.with(binding.root).load(data.urlToImage).into(binding.detailsImage)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}