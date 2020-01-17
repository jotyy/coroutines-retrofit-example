package top.jotyy.coroutinesretrofitexample

import android.os.Bundle
import androidx.fragment.app.commit
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import top.jotyy.coroutinesretrofitexample.ui.login.LoginFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.commit {
            replace(R.id.fragment_container, LoginFragment())
        }
    }
}
