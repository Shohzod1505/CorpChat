package ru.itis.kpfu.corpchat.utils

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast

fun EditText.convert(): String = this.text.toString()

fun String.checkEmpty(context: Context, warning: String): Boolean {
    if (TextUtils.isEmpty(this)) {
        Toast.makeText(context, warning, Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}
