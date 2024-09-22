package com.example.e_commerceapp.mainView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivityHomeBinding
import com.example.e_commerceapp.mainView.categories.CategoriesFragment
import com.example.e_commerceapp.mainView.home.HomeFragment
import com.example.e_commerceapp.mainView.profile.ProfileFragment
import com.example.e_commerceapp.mainView.wishList.WishListFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private val viewModel: HomeActivityViewModel by viewModels()
    private lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iniViews()
    }

    private fun iniViews() {
        viewBinding = DataBindingUtil.setContentView(
            this,R.layout.activity_home
        )
        initNavigationClicks()
    }

    private fun initNavigationClicks() {
        viewBinding.bottomNavHome.setOnItemSelectedListener(this)
        viewBinding.bottomNavHome.selectedItemId = R.id.bottom_nav_home

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bottom_nav_home-> pushFragment(HomeFragment())
            R.id.ic_category_nav-> pushFragment(CategoriesFragment())
            R.id.ic_profile_nav -> pushFragment(ProfileFragment())
            R.id.ic_wish_list_nav-> pushFragment(WishListFragment())
        }
        return true
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_home_container,fragment)
            .commit()
    }
}