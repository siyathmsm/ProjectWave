package com.example.project_management;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FeedbackLead extends AppCompatActivity {
    private TextView searchResultText;
    private DBHandler_AddFeedback dbHandler;
    private Button deletBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.feedback_read_leader);

        searchResultText = findViewById(R.id.search_result_text_feedbacks);
        deletBtn = findViewById(R.id.doneFeedbacks);
        dbHandler = new DBHandler_AddFeedback(FeedbackLead.this);

                List<Feed> feeds = dbHandler.getAllFeedbacks();

                if (feeds.isEmpty()) {
                    searchResultText.setText("You are up to date.");
                    return;
                } else {
                    StringBuilder shoesDetails = new StringBuilder();
                    for (Feed feed : feeds) {
                        shoesDetails.append("Feedback Iteration: ").append(feed.getFeedbackIteration()).append("\n")
                                .append("Group Name: ").append(feed.getGroupName()).append("\n")
                                .append("Title: ").append(feed.getProjectTitle()).append("\n")
                                .append("Document Type: ").append(feed.getDocType()).append("\n")
                                .append("Feedbacks: ").append(feed.getFeedBacks()).append("\n");
                    }
                    searchResultText.setText(shoesDetails.toString());
                }



        deletBtn.setOnClickListener(v -> {
            dbHandler.deleteFeedback();
            Toast.makeText(FeedbackLead.this, "The feedback status has been updated.", Toast.LENGTH_SHORT).show();

        });

    }
}
