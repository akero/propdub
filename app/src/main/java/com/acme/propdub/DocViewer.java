package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class DocViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_viewer);
        WebView webView = findViewById(R.id.webview);

// Enable JavaScript (necessary for Google Drive's viewer)
        webView.getSettings().setJavaScriptEnabled(true);

        String pdfUrl = "https://arxiv.org/pdf/2303.12712.pdf";  // Replace with your PDF URL
        String googleDocsUrl = "https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfUrl;

        webView.loadUrl(googleDocsUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}