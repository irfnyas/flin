package com.example.myapp

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import com.example.myapp.kmm.processMethodChannel

class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(
      flutterEngine: FlutterEngine
    ) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(
          flutterEngine.dartExecutor.binaryMessenger, "/sdk"
        ).apply {
            setMethodCallHandler { call, result ->
                processMethodChannel(
                    call.method ?: "",
                    call.arguments ?: emptyList<String>(),
                    { s -> result.success(s) },
                    { e, e1, e2 -> result.error(e, e1, e2) }
                )
            }
        }
    }
}