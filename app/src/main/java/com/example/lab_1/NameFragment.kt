package com.example.lab_1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lab_1.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    lateinit var binding: FragmentNameBinding

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
                Toast.makeText(context, "Please, enter your shit above", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Move data from the input to livedata and show it in reg_text_res
            }
        }
    }
}