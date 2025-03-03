package com.example.project_management;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDelete extends AppCompatActivity {
    private EditText groupName, title, memberName1, memberIndexNo1, memberRegNo1, memberName2, memberIndexNo2, memberRegNo2, memberName3, memberIndexNo3, memberRegNo3, memberName4, memberIndexNo4, memberRegNo4, memberName5, memberIndexNo5, memberRegNo5;
    private Button searchButton, updateButton, deleteButton;
    private DBHandler_AddGroup dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_delete_group_lead);

        // initializing all our variables.
        groupName = findViewById(R.id.groupNameEdt);
        title = findViewById(R.id.projectTitleEdt);
        memberName1 = findViewById(R.id.memberNameEdt1);
        memberIndexNo1 = findViewById(R.id.indexNoEdt1);
        memberRegNo1 = findViewById(R.id.regNoEdt1);
        memberName2 = findViewById(R.id.memberNameEdt2);
        memberIndexNo2 = findViewById(R.id.indexNoEdt2);
        memberRegNo2 = findViewById(R.id.regNoEdt2);
        memberName3 = findViewById(R.id.memberNameEdt3);
        memberIndexNo3 = findViewById(R.id.indexNoEdt3);
        memberRegNo3 = findViewById(R.id.regNoEdt3);
        memberName4 = findViewById(R.id.memberNameEdt4);
        memberIndexNo4 = findViewById(R.id.indexNoEdt4);
        memberRegNo4 = findViewById(R.id.regNoEdt4);
        memberName5 = findViewById(R.id.memberNameEdt5);
        memberIndexNo5 = findViewById(R.id.indexNoEdt5);
        memberRegNo5 = findViewById(R.id.regNoEdt5);
        searchButton = findViewById(R.id.searchBtn);
        updateButton = findViewById(R.id.updateBtn);
        deleteButton = findViewById(R.id.deleteBtn);
        dbHandler = new DBHandler_AddGroup(this);

        searchButton.setOnClickListener(v -> {
            String GroupName = groupName.getText().toString().trim();

            if (GroupName.isEmpty()) {
                Toast.makeText(UpdateDelete.this, "Please enter the group name.", Toast.LENGTH_SHORT).show();
                return;
            }

            Grp grp = dbHandler.getGroupsByName(GroupName);

            if (grp != null) {
                groupName.setText(grp.getGroupName());
                title.setText(grp.getProjectTitle());
                memberName1.setText(grp.getMemberName1());
                memberIndexNo1.setText(grp.getIndexNo1());
                memberRegNo1.setText(grp.getRegNo1());
                memberName2.setText(grp.getMemberName2());
                memberIndexNo2.setText(grp.getIndexNo2());
                memberRegNo2.setText(grp.getRegNo2());
                memberName3.setText(grp.getMemberName3());
                memberIndexNo3.setText(grp.getIndexNo3());
                memberRegNo3.setText(grp.getRegNo3());
                memberName4.setText(grp.getMemberName4());
                memberIndexNo4.setText(grp.getIndexNo4());
                memberRegNo4.setText(grp.getRegNo4());
                memberName5.setText(grp.getMemberName5());
                memberIndexNo5.setText(grp.getIndexNo5());
                memberRegNo5.setText(grp.getRegNo5());
            } else {
                Toast.makeText(UpdateDelete.this, "Item not found.", Toast.LENGTH_SHORT).show();
            }
        });

        updateButton.setOnClickListener(v -> {
            String GroupName = groupName.getText().toString().trim();
            String Title = title.getText().toString().trim();
            String MemberName1 = memberName1.getText().toString().trim();
            String IndexNo1 = memberIndexNo1.getText().toString().trim();
            String RegNo1 = memberRegNo1.getText().toString().trim();
            String MemberName2 = memberName2.getText().toString().trim();
            String IndexNo2 = memberIndexNo2.getText().toString().trim();
            String RegNo2 = memberRegNo2.getText().toString().trim();
            String MemberName3 = memberName3.getText().toString().trim();
            String IndexNo3 = memberIndexNo3.getText().toString().trim();
            String RegNo3 = memberRegNo3.getText().toString().trim();
            String MemberName4 = memberName4.getText().toString().trim();
            String IndexNo4 = memberIndexNo4.getText().toString().trim();
            String RegNo4 = memberRegNo4.getText().toString().trim();
            String MemberName5 = memberName5.getText().toString().trim();
            String IndexNo5 = memberIndexNo5.getText().toString().trim();
            String RegNo5 = memberRegNo5.getText().toString().trim();

            if (GroupName.isEmpty()) {
                Toast.makeText(UpdateDelete.this, "Please enter the group name.", Toast.LENGTH_SHORT).show();
                return;
            }

            Grp grp = new Grp();
            grp.setGroupName(GroupName);
            grp.setProjectTitle(Title);
            grp.setMemberName1(MemberName1);
            grp.setIndexNo1(IndexNo1);
            grp.setRegNo1(RegNo1);
            grp.setMemberName2(MemberName2);
            grp.setIndexNo2(IndexNo2);
            grp.setRegNo2(RegNo2);
            grp.setMemberName3(MemberName3);
            grp.setIndexNo3(IndexNo3);
            grp.setRegNo3(RegNo3);
            grp.setMemberName4(MemberName4);
            grp.setIndexNo4(IndexNo4);
            grp.setRegNo4(RegNo4);
            grp.setMemberName5(MemberName5);
            grp.setIndexNo5(IndexNo5);
            grp.setRegNo5(RegNo5);

            dbHandler.updateGroup(grp);

            Toast.makeText(UpdateDelete.this, "Book details updated.", Toast.LENGTH_SHORT).show();
            groupName.setText("");
            title.setText("");
            memberName1.setText("");
            memberIndexNo1.setText("");
            memberRegNo1.setText("");
            memberName2.setText("");
            memberIndexNo2.setText("");
            memberRegNo2.setText("");
            memberName3.setText("");
            memberIndexNo3.setText("");
            memberRegNo3.setText("");
            memberName4.setText("");
            memberIndexNo4.setText("");
            memberRegNo4.setText("");
            memberName5.setText("");
            memberIndexNo5.setText("");
            memberRegNo5.setText("");
        });

        deleteButton.setOnClickListener(v -> {
            String GroupName = groupName.getText().toString().trim();

            if (GroupName.isEmpty()) {
                Toast.makeText(UpdateDelete.this, "Please enter the group name.", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.deleteGroup(GroupName);

            Toast.makeText(UpdateDelete.this, "Group deleted.", Toast.LENGTH_SHORT).show();
            groupName.setText("");
            title.setText("");
            memberName1.setText("");
            memberIndexNo1.setText("");
            memberRegNo1.setText("");
            memberName2.setText("");
            memberIndexNo2.setText("");
            memberRegNo2.setText("");
            memberName3.setText("");
            memberIndexNo3.setText("");
            memberRegNo3.setText("");
            memberName4.setText("");
            memberIndexNo4.setText("");
            memberRegNo4.setText("");
            memberName5.setText("");
            memberIndexNo5.setText("");
            memberRegNo5.setText("");
        });

    }
}