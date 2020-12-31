package com.tech.webviewtest

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var et: EditText? = null
    var webview: WebView? = null

    var btn_search: ImageButton? = null
    var btn_google: ImageButton? = null
    var btn_youtube: ImageButton? = null
    var btn_instagram: ImageButton? = null
    var btn_twitter: ImageButton? = null
    var btn_facebook: ImageButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        btn_google?.setOnClickListener(this)
        btn_search?.setOnClickListener(this)
        btn_facebook?.setOnClickListener(this)
        btn_instagram?.setOnClickListener(this)
        btn_twitter?.setOnClickListener(this)
        btn_youtube?.setOnClickListener(this)

        var pDilaog = ProgressDialog(this)
        pDilaog.setTitle("please wait")
        pDilaog.setMessage("please wait ,it's loading")

        webview?.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pDilaog.show()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                pDilaog.dismiss()
            }
        }


        webview?.settings?.builtInZoomControls=true
        webview?.settings?.javaScriptEnabled=true

    }

    private fun init() {
        et = findViewById(R.id.et1_search)
        webview = findViewById(R.id.webview)

        btn_facebook = findViewById(R.id.btn_facebook)
        btn_search = findViewById(R.id.btn_search)
        btn_twitter = findViewById(R.id.btn_twitter)
        btn_youtube = findViewById(R.id.btn_youtube)
        btn_google = findViewById(R.id.btn_google)
        btn_instagram = findViewById(R.id.btn_instagram)
    }

    override fun onClick(v: View?) {//this method will be executed after clicking on buttons
        when (v?.id) {
            R.id.btn_google -> webview?.loadUrl("https://www.google.com/")
            R.id.btn_facebook -> webview?.loadUrl("https://www.facebook.com/")
            R.id.btn_twitter -> webview?.loadUrl("https://twitter.com/?lang=en")
            R.id.btn_instagram -> webview?.loadUrl("https://www.instagram.com/")
            R.id.btn_youtube -> webview?.loadUrl("https://www.youtube.com/")
            R.id.btn_search->webview?.loadUrl("https://${et?.text.toString()}/")
        }

    }
}