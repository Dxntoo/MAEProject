package com.example.dantoo.ui.profile

import android.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.dantoo.R
import com.example.dantoo.databinding.FragmentProfileBinding
import com.example.dantoo.ui.profile.ProfileViewModel

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val tablayout = binding.tabLayout
        val viewPager = binding.viewpager


        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}