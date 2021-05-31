package com.example.etrite.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.etrite.AddNewMealActivity
import com.example.etrite.databinding.FragmentDashboardBinding
import com.example.etrite.firestore.FirestoreClass
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.greetingText

        val db = FirebaseFirestore.getInstance()
        val userid = FirestoreClass().getCurrentUserID()

        val usernameDB = db.collection("users").document(userid)

        usernameDB.get().addOnSuccessListener { document ->
            if(document!=null){
                textView.text = "Hello there, ${document.data?.get("username")}"
            }
        }

        val addnewmeal = binding.addNewMealBtn

        addnewmeal.setOnClickListener{
            startActivity(Intent(this@DashboardFragment.requireActivity(), AddNewMealActivity::class.java))

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}