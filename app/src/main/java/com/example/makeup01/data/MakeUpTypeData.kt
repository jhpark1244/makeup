package com.example.makeup01.data

import androidx.annotation.Keep

@Keep
class MakeUpTypeData (
    val text:String? = "",
    val doImportant:Boolean? = false,
    var doSelected:Boolean? = false
)