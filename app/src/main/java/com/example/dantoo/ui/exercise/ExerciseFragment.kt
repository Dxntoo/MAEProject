package com.example.dantoo.ui.exercise

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dantoo.R
import com.example.dantoo.databinding.FragmentExerciseBinding
import com.example.dantoo.ui.exercise.ExerciseViewModel


class ExerciseFragment : Fragment() {

    private lateinit var exerciseViewModel: ExerciseViewModel
    private var _binding: FragmentExerciseBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exerciseViewModel =
            ViewModelProvider(this).get(ExerciseViewModel::class.java)

        _binding = FragmentExerciseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}