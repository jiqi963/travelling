package wangk6.travelling.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import op.wangk6.travelling.R

class AboutFragment : Fragment() {
    private lateinit var webView: WebView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_about, container, false)
        webView = root.findViewById(R.id.wbv)
        val settings = webView.getSettings()
        settings.javaScriptEnabled = true
        settings.setSupportZoom(true)
        settings.useWideViewPort = true
        webView.loadUrl("https://op-wangk6-travelling.flycricket.io/privacy.html")
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })

        webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack()
                    return@OnKeyListener true
                }
            }
            false
        })
        return root
    }
}