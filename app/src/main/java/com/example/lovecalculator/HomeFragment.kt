package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentHomeBinding
import com.example.lovecalculator.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment  : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel:LoveViewModel by viewModels()

    @Inject
    lateinit var dataBase: AppDataBase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(layoutInflater)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }
    private fun initClicker() {
        with(binding){
            btnCalculate.setOnClickListener{
                with(viewModel) {
                    getLiveLoveModel(etFirstName.text.toString(),etSecondName.text.toString()).observe(
                        this@HomeFragment.viewLifecycleOwner, Observer {loveData->
                                    binding.btnCalculate.text=loveData.percentage
                                    dataBase.loveDao().insert(loveData)
                                })
                }
            }
            btnHistory.setOnClickListener{
                findNavController().navigate(R.id.historyActivity)
            }
        }
    }
}