package com.randhir.trivia.data

data class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null, // here we can pass questionlist as T but now we also have information about loading and exceptions
    var loading: Boolean? = null,
    var e: E? = null
)
