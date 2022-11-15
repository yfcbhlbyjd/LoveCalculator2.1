package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.LoveModel

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentResultBinding.inflate(layoutInflater)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onGet()
    }
    private fun onGet() {
        val loveModel:LoveModel=arguments?.getSerializable("key") as LoveModel
        binding.etFirstName.text=loveModel.firstName
        binding.etSecondName.text=loveModel.secondName
        binding.tvPercentage.text=loveModel.percentage
        binding.tvResult.text=loveModel.result
    }
}