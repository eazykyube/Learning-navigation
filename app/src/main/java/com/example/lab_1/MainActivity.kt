package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lab_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.loginButton.setOnClickListener {
            checkLogin(it)
        }

        binding.logoutButton.setOnClickListener {
            logout(it)
        }
    }

    private fun checkLogin(view: View) {
        binding.apply {
            if (TextUtils.isEmpty(binding.nameEdit.text.toString()) or TextUtils.isEmpty(binding.pwdEdit.text.toString())) {
                Toast.makeText(applicationContext, "Please, enter your shit above", Toast.LENGTH_SHORT).show();
            } else {
                binding.nameEdit.text.clear()
                binding.pwdEdit.text.clear()
                binding.nameEdit.visibility = View.GONE
                binding.pwdEdit.visibility = View.GONE
                binding.loginButton.visibility = View.GONE
                binding.registerText.visibility = View.GONE
                invalidateAll()
                binding.logoutButton.visibility = View.VISIBLE
            }
        }
    }

    private fun logout(view: View) {
        binding.apply {
            binding.logoutButton.visibility = View.GONE
            invalidateAll()
                binding.nameEdit.visibility = View.VISIBLE
                binding.pwdEdit.visibility = View.VISIBLE
                binding.loginButton.visibility = View.VISIBLE
                binding.registerText.visibility = View.VISIBLE
        }
    }
}