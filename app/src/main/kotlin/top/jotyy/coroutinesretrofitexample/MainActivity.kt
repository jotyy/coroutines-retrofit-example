package top.jotyy.coroutinesretrofitexample

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import top.jotyy.coroutinesretrofitexample.databinding.MainActivityBinding
import top.jotyy.coroutinesretrofitexample.ui.login.LoginFragment

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.drawerLayout.setStatusBarBackground(R.color.primaryColor)
        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration.Builder(R.id.articleFragment)
            .setDrawerLayout(binding.drawerLayout)
            .build()

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
}
