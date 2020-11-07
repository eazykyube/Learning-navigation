package com.example.lab_1

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.lab_1.databinding.FragmentLoginBinding
import kotlin.math.log

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var loggedState: Boolean = false
    private var myName: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.loginButton.setOnClickListener {
            checkLogin(it)
        }

        binding.logoutButton.setOnClickListener {
            logout(it)
        }

        binding.registerText.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_nameFragment)
        )

        return binding.root
    }

    private fun checkLogin(view: View) {
        binding.apply {
            if (TextUtils.isEmpty(binding.nameEdit.text.toString()) or TextUtils.isEmpty(binding.pwdEdit.text.toString())) {
                Toast.makeText(context, "Please, enter your shit above", Toast.LENGTH_SHORT).show();
            } else {
                loggedState = true
                myName = binding.nameEdit.text.toString()
                binding.name = myName
                //                binding.age
                binding.nameEdit.text.clear()
                binding.pwdEdit.text.clear()

                binding.nameEdit.visibility = View.GONE
                binding.pwdEdit.visibility = View.GONE
                binding.loginButton.visibility = View.GONE
                binding.registerText.visibility = View.GONE
                binding.nameLog.visibility = View.VISIBLE
//                binding.ageLog.visibility = View.VISIBLE
                binding.logoutButton.visibility = View.VISIBLE
                invalidateAll()
            }
        }
    }

    private fun logout(view: View) {
        binding.apply {
            loggedState = false
            myName = ""
            binding.logoutButton.visibility = View.GONE
            binding.nameLog.visibility = View.GONE
            binding.nameEdit.visibility = View.VISIBLE
            binding.pwdEdit.visibility = View.VISIBLE
            binding.loginButton.visibility = View.VISIBLE
            binding.registerText.visibility = View.VISIBLE
            invalidateAll()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", myName)
        outState.putBoolean("logged", loggedState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            loggedState = savedInstanceState.getBoolean("logged")
            binding.name = savedInstanceState.getString("name")
            if (loggedState) {
                binding.apply {
                    binding.nameEdit.visibility = View.GONE
                    binding.pwdEdit.visibility = View.GONE
                    binding.loginButton.visibility = View.GONE
                    binding.registerText.visibility = View.GONE
                    binding.nameLog.visibility = View.VISIBLE
                    binding.logoutButton.visibility = View.VISIBLE
                    invalidateAll()
                }
            }
        }
    }
}