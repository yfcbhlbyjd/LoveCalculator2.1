package com.geektech.lovecalculator.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.geektech.lovecalculator.Model.LoveModel


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        val love = arguments?.getSerializable("love") as LoveModel
        with(binding) {
            etFirstName.text = love.firstName
            etSecondName.text = love.secondName
            tvResult.text = love.result
            tvPercentage.text = love.percentage.plus("%")
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
    }

