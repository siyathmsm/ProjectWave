package com.example.project_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.register_activity);

    }

    public void onLoginClicked(View view) {
        // Navigate to the RegisterActivity
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
