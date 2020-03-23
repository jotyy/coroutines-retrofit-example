package top.jotyy.coroutinesretrofitexample.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

class SnackbarBehavior constructor(
    context: Context,
    attributeSet: AttributeSet
) : CoordinatorLayout.Behavior<View>() {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean = dependency is Snackbar.SnackbarLayout

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val translationY = 0.0f.coerceAtMost((dependency.translationY - dependency.height))
        child.translationY = translationY
        return true
    }
}