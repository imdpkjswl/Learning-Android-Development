package com.iamdj.a5webviewwithexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DYNAMIC WEB VIEW : 1.Get Internet acces by manifest 2.Write xml 3.then write java code.
        WebView wv = (WebView)findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com");
        Toast.makeText(this,"Dynamic web view started...",Toast.LENGTH_LONG).show();


        // STATIC WEB VIEW
/*        WebView wv = (WebView) findViewById(R.id.webview);
        String customHtml = "<html><body>" +
                                    "<h1>DEEPAK JAISWAL <br><br>Welcome to Learning Portal</h1>" +
                                    "<h2>Welcome to Learning Portal</h2>" +
                                    "<h3>Welcome to Learning Portal</h3>" +
                                    "<p>It's a Static Web HTML Content.</p>" +
                            "</body></html>";
        wv.loadData(customHtml, "text/html", "UTF-8");
*/
    }
}