package com.example.utsiqbal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasuts.R


@SuppressLint("Registered")
class FakulWeb : AppCompatActivity() {
    // Inisiasi Javascript
    @SuppressLint("Registered")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting Layout
        setContentView(R.layout.web_activity)

        // Inisiasi WebView
        val webView = findViewById<WebView>(R.id.webview)

        // Inisiasi Intent
        val intentFromFac = intent

        if (intentFromFac.hasExtra(Intent.ACTION_VIEW)) {
            // Grab Intent Detail Fac
            val partWeb = intentFromFac.getStringExtra(Intent.ACTION_VIEW)
            webView.settings.javaScriptEnabled = true

            // Proses Load Client -> Alert Javascript Created
            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Website Successfull!')")
                }
            }

            // Alert Javascript -> Toast
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@FakulWeb, message, Toast.LENGTH_LONG).show()
                    result.confirm()
                    return true
                }
            }

            // Parameter WebView Load
            webView.loadUrl(partWeb)
        }
    }
}