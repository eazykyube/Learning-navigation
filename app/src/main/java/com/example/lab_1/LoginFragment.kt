package com.example.lab_1

import android.content.res.Resources
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
    lateinit var users: Users
    private var loggedState: Boolean = false
    private var myName: String? = ""
    private var myAge: Int? = 0
    private var myPwd: String? = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        users = Users()

        binding.loginButton.setOnClickListener {
            var currentName = getArguments()?.getString("name").toString()
            var currentAge = getArguments()?.getString("age").toString()
            var currentPwd = getArguments()?.getString("pwd").toString()
            if (!users.findUser(currentName) and (currentName.isNotEmpty())) {
                users.addUser(currentName, currentAge, currentPwd)
            }
            if (users.size() > 0) {
                checkLogin(it)
            } else {
                Toast.makeText(context, "Please, register", Toast.LENGTH_SHORT).show();
            }
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
                Toast.makeText(context, "Please, enter your data above", Toast.LENGTH_SHORT).show();
            } else {
                if (users.findUser(binding.nameEdit.text.toString()) and
                        users.getPwd(binding.nameEdit.text.toString()).equals(binding.pwdEdit.text.toString())) {

                    loggedState = true
                    myName = users.getName(binding.nameEdit.text.toString())
                    myAge = users.getAge(binding.nameEdit.text.toString()).toInt()
                    myPwd = users.getPwd(binding.nameEdit.text.toString())

                    binding.name = myName
                    binding.age = myAge
                    binding.pwd = myPwd
                    binding.nameEdit.text.clear()
                    binding.pwdEdit.text.clear()

                    binding.nameEdit.visibility = View.GONE
                    binding.pwdEdit.visibility = View.GONE
                    binding.loginButton.visibility = View.GONE
                    binding.registerText.visibility = View.GONE
                    binding.nameLog.visibility = View.VISIBLE
                    binding.ageLog.visibility = View.VISIBLE
                    binding.pwdLog.visibility = View.VISIBLE
                    binding.logoutButton.visibility = View.VISIBLE
                    invalidateAll()
                } else {
                    Toast.makeText(context, "Not registered", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private fun logout(view: View) {
        binding.apply {
            loggedState = false
            myName = ""
            myAge = 0
            myPwd = ""
            binding.logoutButton.visibility = View.GONE
            binding.nameLog.visibility = View.GONE
            binding.ageLog.visibility = View.GONE
            binding.pwdLog.visibility = View.GONE
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
        outState.putInt("age", myAge!!)
        outState.putString("pwd", myPwd)
        outState.putBoolean("logged", loggedState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            loggedState = savedInstanceState.getBoolean("logged")
            myName = savedInstanceState.getString("name")
            binding.name = myName
            myAge = savedInstanceState.getInt("age")
            binding.age = myAge
            myPwd = savedInstanceState.getString("pwd")
            binding.pwd = myPwd
            if (loggedState) {
                binding.apply {
                    binding.nameEdit.visibility = View.GONE
                    binding.pwdEdit.visibility = View.GONE
                    binding.loginButton.visibility = View.GONE
                    binding.registerText.visibility = View.GONE
                    binding.nameLog.visibility = View.VISIBLE
                    binding.ageLog.visibility = View.VISIBLE
                    binding.pwdLog.visibility = View.VISIBLE
                    binding.logoutButton.visibility = View.VISIBLE
                    invalidateAll()
                }
            }
        }
    }
}