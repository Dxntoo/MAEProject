package com.example.etrite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etrite.databinding.FragmentChatroomSelectionBinding
import com.example.etrite.databinding.FragmentFoodBinding

class ChatroomSelectionFragment : Fragment() {
    private var _binding: FragmentChatroomSelectionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChatroomSelectionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment

        val foodbar = binding.chatroomBar

        foodbar.setOnClickListener{
            val intent = Intent(this@ChatroomSelectionFragment.requireActivity(), ChatroomActivity::class.java)
            startActivity(intent)
        }
        return root
    }


}