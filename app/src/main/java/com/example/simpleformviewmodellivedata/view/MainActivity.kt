package com.example.simpleformviewmodellivedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.livedataviewmodel.viewmodel.UserViewModel
import com.example.simpleformviewmodellivedata.R
import com.example.simpleformviewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val userViewModel by lazy {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        Log.d("onCreate", savedInstanceState.toString())
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.setLifecycleOwner(this)
        activityMainBinding.loginmodel = userViewModel

        userViewModel.getResult().observe(this, Observer {
            Log.d("observer", "test")
            activityMainBinding.textviewData.setText(it.firstname + " " + it.lastname)
        })

    }
}
