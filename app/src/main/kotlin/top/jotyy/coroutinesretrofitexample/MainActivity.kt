package top.jotyy.coroutinesretrofitexample

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import top.jotyy.coroutinesretrofitexample.databinding.MainActivityBinding
import top.jotyy.coroutinesretrofitexample.ui.login.LoginFragment

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.toolbar, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!NavigationUI.navigateUp(navController, null)) {
            onBackPressed()
        }

        return true
    }
}
