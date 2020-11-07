package com.example.lab_1

import android.os.Bundle
import android.os.Parcelable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab_1.databinding.FragmentPwdBinding
import java.util.*


class PwdFragment : Fragment() {

    lateinit var binding: FragmentPwdBinding
    private lateinit var bundle: Bundle
    var name: String? = ""
    var age: String? = ""
    var pwd: String? = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_pwd, container, false
        )

        binding.regButton.setOnClickListener {
            checkRegister(it)
        }

        return binding.root
    }

    private fun checkRegister(view: View) {
        binding.apply {
            if (TextUtils.isEmpty(binding.pwdEditReg.text.toString())) {
                Toast.makeText(context, "Please, enter your shit above", Toast.LENGTH_SHORT).show();
            } else {

                name = getArguments()?.getString("name").toString()
                age = getArguments()?.getString("age").toString()
                pwd = binding.pwdEditReg.text.toString()

                bundle = Bundle()
                bundle.putString("name", name)
                bundle.putString("age", age)
                bundle.putString("pwd", pwd)

                view.findNavController().navigate(R.id.action_pwdFragment_to_loginFragment, bundle)
            }
        }
    }
}
