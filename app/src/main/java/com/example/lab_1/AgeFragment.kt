package com.example.lab_1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab_1.databinding.FragmentAgeBinding

class AgeFragment : Fragment() {

    lateinit var binding: FragmentAgeBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_age, container, false
        )

        binding.nextButton.setOnClickListener {
            checkRegister(it)
        }

        return binding.root
    }

    private fun checkRegister(view: View) {
        binding.apply {
            if (TextUtils.isEmpty(binding.ageEditReg.text.toString())) {
                Toast.makeText(context, "Please, enter your shit above", Toast.LENGTH_SHORT).show();
            } else {
                bundle = Bundle()
                bundle.putString("name", getArguments()?.getString("name"))
                bundle.putString("age", binding.ageEditReg.text.toString())
                view.findNavController().navigate(R.id.action_ageFragment_to_pwdFragment, bundle)
            }
        }
    }
}