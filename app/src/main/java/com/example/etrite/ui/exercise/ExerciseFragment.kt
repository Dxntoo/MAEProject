package com.example.etrite.ui.exercise

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etrite.RecipeActivity
import com.example.etrite.RoutineActivity
import com.example.etrite.databinding.FragmentExerciseBinding


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

        val viewRoutine = binding.recommendedImage

        viewRoutine.setOnClickListener{
            startActivity(Intent(this@ExerciseFragment.requireActivity(), RoutineActivity::class.java))

        }

        val viewRecipe = binding.recipeImage

        viewRecipe.setOnClickListener{
            startActivity(Intent(this@ExerciseFragment.requireActivity(), RecipeActivity::class.java))
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}