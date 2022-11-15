package com.example.lovecalculator.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentBoardBinding
import com.example.lovecalculator.databinding.ItemBoardBinding
import com.example.lovecalculator.onboard.Board

class BoardAdapter(var context: Context, private var navController: NavController, private var skip: FragmentBoardBinding)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val board= arrayListOf<Board>()
    init {
        board.add(Board(R.raw.board1,
            "Have a good time",
            "You should take the time to help those who need you"))
        board.add(Board(R.raw.board2,
            "Cherishing love",
            "It is now no longer possible for you to cherish love"))
        board.add(Board(R.raw.board3,      "Have a breakup?",
            "We have made the correction for you don't worry\nMaybe someone is waiting for you!"))
        board.add(Board(R.raw.board4,"Love Calculator",
            "Well come"))

    }
    inner class ViewHolder(
        private var binding: ItemBoardBinding
    )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.animationView.setAnimation(board.image)
            binding.textTitle.text = board.title
            binding.textDesc.text = board.description
            skip.textSkip.setOnClickListener {
                val prefs= Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            binding.btnStart.setOnClickListener {
                val prefs=Prefs(context)
                prefs.saveState()
                navController.navigate(R.id.mainFragment)
            }
            if (this@BoardAdapter.board.lastIndexOf(board) == this@BoardAdapter.board.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            } else{
                binding.btnStart.visibility = View.INVISIBLE
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(board[position])
    }

    override fun getItemCount()=board.size
}