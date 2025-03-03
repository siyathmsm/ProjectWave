package com.example.project_management;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ViewGroupSupervisor extends AppCompatActivity {
    private TextView searchResultText;
    private DBHandler_AddGroup dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use setContentView to set the layout for this activity
        setContentView(R.layout.view_groups_supervisor);

        searchResultText = findViewById(R.id.search_result_text);
        dbHandler = new DBHandler_AddGroup(ViewGroupSupervisor.this);

                List<Grp> grps = dbHandler.getAllGroups();

                if (grps.isEmpty()) {
                    searchResultText.setText("No groups found.");
                    return;
                } else {
                    StringBuilder groupDetails = new StringBuilder();
                    for (Grp grp : grps) {
                        groupDetails.append("Group Name: ").append(grp.getGroupName()).append("\n")
                                .append("Project Title: ").append(grp.getProjectTitle()).append("\n")
                                .append("Member 1: ").append(grp.getMemberName1()).append(", ")
                                .append(grp.getIndexNo1()).append(", ")
                                .append(grp.getRegNo1()).append("\n")
                                .append("Member 2: ").append(grp.getMemberName2()).append(", ")
                                .append(grp.getIndexNo2()).append(", ")
                                .append(grp.getRegNo2()).append("\n")
                                .append("Member 3: ").append(grp.getMemberName3()).append(", ")
                                .append(grp.getIndexNo3()).append(", ")
                                .append(grp.getRegNo3()).append("\n")
                                .append("Member 4: ").append(grp.getMemberName4()).append(", ")
                                .append(grp.getIndexNo4()).append(", ")
                                .append(grp.getRegNo4()).append("\n")
                                .append("Member 5: ").append(grp.getMemberName5()).append(", ")
                                .append(grp.getIndexNo5()).append(", ")
                                .append(grp.getRegNo5()).append("\n");
                    }
                    searchResultText.setText(groupDetails.toString());
                }
    }
}