package com.go.arnite.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Mentor(
    var id: String? = "",
    var email: String? = ""
)