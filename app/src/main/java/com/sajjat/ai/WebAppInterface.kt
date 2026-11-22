
package com.sajjat.ai

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(
    private val context: Context,
    private val onStartScreenShare: () -> Unit
) {

    @JavascriptInterface
    fun startNativeScreenCapture() {
        (context as? MainActivity)?.runOnUiThread {
            onStartScreenShare()
        }
    }

    @JavascriptInterface
    fun stopNativeScreenCapture() {
        val intent = android.content.Intent(
            context,
            ScreenShareService::class.java
        )
        context.stopService(intent)
    }

    @JavascriptInterface
    fun showToast(message: String) {
        Toast.makeText(
            context,
            message.take(150),
            Toast.LENGTH_SHORT
        ).show()
    }
}
