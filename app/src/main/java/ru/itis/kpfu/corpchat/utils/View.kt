package ru.itis.kpfu.corpchat.utils

import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.*

fun EditText.getTextAsString(): String = this.text.toString()

fun String.checkEmpty(warning: String): Boolean {
    if (this.isEmpty()) {
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

fun generatePassword(length: Int): String {
    val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val password = StringBuilder()
    val random = Random()

    for (i in 0 until length) {
        val index = random.nextInt(chars.length)
        password.append(chars[index])
    }

    return password.toString()
}
