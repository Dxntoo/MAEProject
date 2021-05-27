package com.example.dantoo.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dantoo.LoginActivity
import com.example.dantoo.databinding.FragmentProfileBinding
import com.example.dantoo.utils.Constants
import com.example.dantoo.viewpager.PhotoFragment
import com.example.dantoo.viewpager.PostFragment
import com.example.dantoo.viewpager.ProgressFragment
import com.example.dantoo.viewpager.ViewPagerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_profile.*
import com.example.dantoo.firestore.FirestoreClass
import com.example.dantoo.models.User
import com.google.firebase.auth.FirebaseUser



class ProfileFragment : Fragment(){
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

        val viewPager = binding.viewpager

        val fragments: ArrayList<Fragment> = arrayListOf(
            PostFragment(),
            PhotoFragment(),
            ProgressFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)


        val usernametext = binding.profileUsernameText
        val db = FirebaseFirestore.getInstance()

        val userid = FirestoreClass().getCurrentUserID()
        val usernameDB = db.collection("users").document(userid)




        usernameDB.get().addOnSuccessListener { document ->
            if(document!=null){
                usernametext.text = "${document.data}"
            }
        }






        val logout = binding.logoutBtn


        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@ProfileFragment.requireActivity(), LoginActivity::class.java))
            activity?.finish()
        }

        viewPager.adapter = adapter

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






}


