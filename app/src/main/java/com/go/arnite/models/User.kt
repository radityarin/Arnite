package com.go.arnite.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var id: String? = "",
    var email: String? = "",
    var name: String? = "",
    var phoneNumber: String? = ""
)