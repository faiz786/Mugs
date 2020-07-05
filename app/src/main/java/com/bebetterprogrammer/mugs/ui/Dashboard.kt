package com.bebetterprogrammer.mugs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bebetterprogrammer.mugs.R
import com.bebetterprogrammer.mugs.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        initView()
    }

    private fun initView() {
         var intent = intent
         val username = intent.getStringExtra("username")
         binding.username.text = "Welcome "+username
    }
}
