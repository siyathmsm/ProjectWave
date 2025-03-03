package com.example.project_management;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackSup extends AppCompatActivity {
    private EditText feedBackIteLbl, groupNameLbl, titleLbl, typeLbl, feedbackLbl;
    private DBHandler_AddFeedback dbHandler;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.feedback_write_supervisor);

        // initializing all our variables.
        feedBackIteLbl = findViewById(R.id.feedbackIterationEdt);
        groupNameLbl = findViewById(R.id.groupNameEdt);
        titleLbl = findViewById(R.id.projectTitleEdt);
        typeLbl = findViewById(R.id.docTypeEdt);
        feedbackLbl = findViewById(R.id.feedbackEdt);
        addButton = findViewById(R.id.submitFeedbacks);

        dbHandler = new DBHandler_AddFeedback(FeedbackSup.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedBackIter = feedBackIteLbl.getText().toString();
                String groupName = groupNameLbl.getText().toString();
                String projectTitle = titleLbl.getText().toString();
                String docType = typeLbl.getText().toString();
                String feedBack = feedbackLbl.getText().toString();

                if (feedBackIter.isEmpty() && groupName.isEmpty() && projectTitle.isEmpty() && docType.isEmpty() && feedBack.isEmpty()) {
                    Toast.makeText(FeedbackSup.this, "Please enter all the datas..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewFeedback(feedBackIter, groupName, projectTitle, docType,feedBack);

                Toast.makeText(FeedbackSup.this, "Feedback has been added.", Toast.LENGTH_SHORT).show();
                feedBackIteLbl.setText("");
                groupNameLbl.setText("");
                titleLbl.setText("");
                typeLbl.setText("");
                feedbackLbl.setText("");
            }
        });
    }
}