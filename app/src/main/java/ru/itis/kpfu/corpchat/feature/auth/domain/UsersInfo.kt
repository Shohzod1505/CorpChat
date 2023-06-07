package ru.itis.kpfu.corpchat.feature.auth.domain

data class UsersInfo(
    val userid: String,
    val name: String,
    val lastname: String,
    val password: String,
    val email: String,
    val phone: String,
    val company: String,
    val image: String,
) {
    constructor() : this(
        userid = "",
        name = "",
        lastname = "",
        password = "",
        email = "",
        phone = "",
        company = "",
        image = "",
    )
}
