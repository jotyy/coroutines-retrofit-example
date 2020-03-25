package top.jotyy.coroutinesretrofitexample.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import top.jotyy.coroutinesretrofitexample.R

fun Fragment.openHome() =
    NavHostFragment.findNavController(this)
        .navigate(R.id.action_loginFragment_to_homeFragment)

fun Fragment.openRegister() =
    NavHostFragment.findNavController(this)
        .navigate(R.id.action_loginFragment_to_registerFragment)