package com.example.myapp.kmm


expect object Sdk {
    val platformName: String
}

fun processMethodChannel(
    method: String,
    params: Any,
    success: (Any) -> Unit,
    error: (String?, String?, String?) -> Unit
) {
    when (method) {
        "platformName" -> success(platformName())
        else -> error("unknown method", "unknown method", "unknown method")
    }
}

fun platformName() = Sdk.platformName