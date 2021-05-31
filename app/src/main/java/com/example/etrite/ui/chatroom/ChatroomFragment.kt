package com.example.etrite.ui.chatroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.etrite.databinding.FragmentChatroomBinding
import com.example.etrite.databinding.FragmentFoodBinding

class ChatroomFragment : Fragment() {

    private lateinit var chatroomViewModel: ChatroomViewModel
    private var _binding: FragmentChatroomBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        chatroomViewModel =
            ViewModelProvider(this).get(ChatroomViewModel::class.java)

        _binding = FragmentChatroomBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}