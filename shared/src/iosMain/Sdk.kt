package com.example.myapp.kmm


import platform.UIKit.UIDevice
import platform.darwin.*

actual object Sdk {
    actual val platformName: String = 
        UIDevice.currentDevice.systemName() +
        " " +
        UIDevice.currentDevice.systemVersion
}
