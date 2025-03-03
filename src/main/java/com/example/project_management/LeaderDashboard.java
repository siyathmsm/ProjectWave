package com.example.project_management;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LeaderDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.leader_dashboard);

        //Option 1 : Add Book
        ImageView option1 = findViewById(R.id.addGroupLeadImg);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderDashboard.this, AddGroupLead.class);
                startActivity(intent);
            }
        });

        //Option 2 : Update Book
        ImageView option2 = findViewById(R.id.feedbackLeadImg);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderDashboard.this, FeedbackLead.class);
                startActivity(intent);
            }
        });

        //Option 3 : View Book
        ImageView option3 = findViewById(R.id.uploadLeadImg);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderDashboard.this, UploadLead.class);
                startActivity(intent);
            }
        });

        //Option 4 : Add Members
        ImageView option4 = findViewById(R.id.downloadLeadImg);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderDashboard.this, DownloadLead.class);
                startActivity(intent);
            }
        });

        //Option 5 : Add Members
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView option5 = findViewById(R.id.updateDeleteImg);
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaderDashboard.this, UpdateDelete.class);
                startActivity(intent);
            }
        });

    }
}
