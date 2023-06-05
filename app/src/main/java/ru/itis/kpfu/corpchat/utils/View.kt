package ru.itis.kpfu.corpchat.utils

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

fun EditText.getTextAsString(): String = this.text.toString()

fun String.checkEmpty(context: Context, warning: String): Boolean {
    if (TextUtils.isEmpty(this)) {
        Toast.makeText(context, warning, Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun Fragment.show(id: Int) {
    requireActivity().findViewById<View>(id).visibility = View.VISIBLE
}

fun Fragment.hide(id: Int) {
    requireActivity().findViewById<View>(id).visibility = View.GONE
}


