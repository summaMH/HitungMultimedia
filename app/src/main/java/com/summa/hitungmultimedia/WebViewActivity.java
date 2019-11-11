package com.summa.hitungmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    //globsl vsrisble
    WebView webViewYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //inisialisasi (tiap var widget butuh ini)
        webViewYoutube = (WebView) findViewById(R.id.webview_youtube);
        //if SDK version is greater of 19 then activate hardware acceleration otherwise activate software acceleration
        if (Build.VERSION.SDK_INT >= 19) {
            webViewYoutube.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
            webViewYoutube.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        //atribute buka via app nya
        //webViewYoutube.loadUrl("https://m.youtube.com");
        //webViewYoutube.getSettings().setJavaScriptEnabled(true);
        //webViewYoutube.setWebChromeClient(new WebChromeClient()); buat di app nya (?)
        //webViewYoutube.setWebViewClient(new WebViewClient()); gapake ini, ini untuk dibuka via web

        //atribute buka via webbrowser
        webViewYoutube.loadUrl("https://www.youtube.com");
        webViewYoutube.getSettings().setJavaScriptEnabled(true);
        webViewYoutube.setWebChromeClient(new WebChromeClient());
        webViewYoutube.setWebViewClient(new WebViewClient());

    }

            //biar pas balik ke hal sebelumnya pake ini, super jadi dibawah

            @Override
            public void onBackPressed() {
                if (webViewYoutube.canGoBack()) {
                    webViewYoutube.goBack();
                } else {
                    super.onBackPressed();
        }
    }
}
// pakai emulator dibawah pie. klo pake pie masih belum bisa konek jaringan internetnya