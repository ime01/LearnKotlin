package com.flowz.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.activity_web_view.view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val intent = intent.extras

        entered_url.setText(intent.getString("website"))


        val site: String = entered_url.text.toString()

        web_view.webViewClient = MyWebViewClient()

        loadWebsite()


//        go.setOnClickListener {
//            web_view.loadUrl("https://" + entered_url.text.toString())
//        }
        back.setOnClickListener {
            if (web_view.canGoBack())
                web_view.goBack()
            else Toast.makeText(this, "No History Available", Toast.LENGTH_SHORT).show()
        }
        forward.setOnClickListener {
            if (web_view.canGoForward())
                web_view.goForward()
            else Toast.makeText(this, "No History Available", Toast.LENGTH_SHORT).show()
        }

    }

    fun loadWebsite (){
        web_view.loadUrl("https://" + entered_url.text.toString())
        go.visibility = View.INVISIBLE
        entered_url.visibility = View.INVISIBLE
    }

    class  MyWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

    }
}
