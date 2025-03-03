package com.example.project_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText, passwordEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.login_activity);

        addButton = findViewById(R.id.loginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = usernameEditText.getText().toString();
                String passWord = passwordEditText.getText().toString();

                // Check if email and password are equal to "admin"
                if (userName.equals("admin") && passWord.equals("admin")) {
                    // Show success message
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Navigate to SupervisorActivity
                    Intent intent = new Intent(LoginActivity.this, SupervisorDashboard.class);
                    startActivity(intent);
                    // Clear text fields
                    clearFields();
                } else if (userName.equals("user") && passWord.equals("user")) {
                    // Show success message
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Navigate to SupervisorActivity
                    Intent intent = new Intent(LoginActivity.this, LeaderDashboard.class);
                    startActivity(intent);
                    // Clear text fields
                    clearFields();
                } else {
                    // Show error message
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    // Clear text fields
                    clearFields();
                }
            }
        });
    }

    // Method to clear the text fields
    private void clearFields() {
        usernameEditText.setText("");
        passwordEditText.setText("");
    }
}