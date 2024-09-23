package com.example.e_commerceapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivitySplashBinding
import com.example.e_commerceapp.mainView.HomeActivity

class SplashActivity : AppCompatActivity() {
    private  var viewBinding: ActivitySplashBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(
            this,R.layout.activity_splash)

        Handler(Looper.getMainLooper())
            .postDelayed({
                         navigateToHomeActivity()
            },2000)
    }
    private fun navigateToHomeActivity() {
        startActivity(Intent(this,HomeActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}