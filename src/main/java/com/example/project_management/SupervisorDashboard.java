package com.example.project_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SupervisorDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.supervisor_dashboard);

        //Option 1 : Add Book
        ImageView option1 = findViewById(R.id.viewGroupSupImg);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupervisorDashboard.this, ViewGroupSupervisor.class);
                startActivity(intent);
            }
        });

        //Option 2 : Update Book
        ImageView option2 = findViewById(R.id.feedbackSupImg);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupervisorDashboard.this, FeedbackSup.class);
                startActivity(intent);
            }
        });

        //Option 3 : View Book
        ImageView option3 = findViewById(R.id.downloadSupImg);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupervisorDashboard.this, DownloadSup.class);
                startActivity(intent);
            }
        });

        //Option 4 : Add Members
        ImageView option4 = findViewById(R.id.uploadSupImg);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupervisorDashboard.this, UploadSup.class);
                startActivity(intent);
            }
        });

    }
}
