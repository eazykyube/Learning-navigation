package com.example.lab_1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lab_1.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    lateinit var binding: FragmentNameBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_name, container, false
        )

        binding.nextButton.setOnClickListener {
            checkRegister(it)
        }

        return binding.root
    }

    private fun checkRegister(view: View) {
        binding.apply {
            if (TextUtils.isEmpty(binding.nameEditReg.text.toString())) {
                Toast.makeText(context, "Please, enter your data above", Toast.LENGTH_SHORT).show();
            } else {
                bundle = Bundle()
                bundle.putString("name", binding.nameEditReg.text.toString())
                view.findNavController().navigate(R.id.action_nameFragment_to_ageFragment, bundle)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

    }
}