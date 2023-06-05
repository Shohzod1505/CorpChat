package ru.itis.kpfu.corpchat.utils

interface ResourceProvider {

    fun getString(id: Int): String

}
