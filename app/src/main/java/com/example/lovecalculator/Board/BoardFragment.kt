package com.geektech.lovecalculator.Board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.Board.Board
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentBoardBinding
import com.geektech.lovecalculator.Prefs


class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentBoardBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(requireContext(), findNavController())
        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        adapter.addItem(
            Board(
                R.raw.board1,
                "Have a good time",
                "You should take the time to help those who need you"
            )
        )
        adapter.addItem(
            Board(
                R.raw.board2,
                "Cherishing love",
                "It is now no longer possible for you to cherish love"
            )
        )
        adapter.addItem(
            Board(
                R.raw.board3,
                "Have a breakup?",
                "We have made the correction for you don't worry\nMaybe someone is waiting for you!"
            )
        )
        adapter.addItem(Board(R.raw.board4, "", "It's Fans and Many more"))

        binding.textSkip.setOnClickListener {
            Prefs().saveState(requireContext())
            findNavController().navigateUp()
        }
    }


}


