package com.example.project_management;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final int LOADING_DELAY = 2000; // Delay time in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preloader);

        // Finding the preloader layout by its ID
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RelativeLayout preloaderLayout = findViewById(R.id.preloaderLayout);

        // To show the preloader
        preloaderLayout.setVisibility(View.VISIBLE);

        // Using Handler to delay the redirection
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hide the preloader
                preloaderLayout.setVisibility(View.GONE);

                // Redirect to the login activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Optional, if you want to finish the current activity
            }
        }, LOADING_DELAY);
    }
}
