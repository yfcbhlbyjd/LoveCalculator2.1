package com.example.lovecalculator.Fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.geektech.lovecalculator.App
import com.geektech.lovecalculator.App.Companion.db
import com.geektech.lovecalculator.Room.HistoryDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    @Inject
    lateinit var dataBase: HistoryDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db.historyDao().getAll().observe(this, Observer { historyList ->
            var history = ""
            historyList.forEach { model ->
                history += "${model.firstName}\n ${model.secondName}\n ${model.percentage}\n ${model.result}\n\n "
            }
            binding.historyTv.text = historyList.toString()


        })
    }
}