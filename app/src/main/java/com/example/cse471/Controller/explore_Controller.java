package com.example.cse471.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cse471.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class explore_Controller extends AppCompatActivity {

    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_controller);
        getSupportActionBar().hide();

        web = findViewById(R.id.logan);

        WebSettings webSettings = web.getSettings();

        webSettings.setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient());// to show the web in our own andorid

        web.getSettings().setBuiltInZoomControls(true);// to set the zoom control

        web.loadUrl("https://www.bracu.ac.bd/");
    }

}