package com.example.etrite.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etrite.AddFoodItemActivity
import com.example.etrite.AddNewMealActivity
import com.example.etrite.FoodItemActivity
import com.example.etrite.databinding.FragmentFoodBinding


class FoodFragment : Fragment() {
    private var _binding: FragmentFoodBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val foodItem = binding.foodItemBar

        foodItem.setOnClickListener{
            val intent = Intent(this@FoodFragment.requireActivity(), AddFoodItemActivity::class.java)
            startActivity(intent)
        }

        return root



    }


}