package com.example.project_management;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddGroupLead extends AppCompatActivity {
    private EditText groupNameEdt, titleEdt, memberNameEdt1, memberIndexNoEdt1, memberRegNoEdt1, memberNameEdt2, memberIndexNoEdt2, memberRegNoEdt2, memberNameEdt3, memberIndexNoEdt3, memberRegNoEdt3, memberNameEdt4, memberIndexNoEdt4, memberRegNoEdt4, memberNameEdt5, memberIndexNoEdt5, memberRegNoEdt5;
    private DBHandler_AddGroup dbHandler;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_group_leader);

        // initializing all our variables.
        groupNameEdt = findViewById(R.id.groupNameEdt);
        titleEdt = findViewById(R.id.projectTitleEdt);
        memberNameEdt1 = findViewById(R.id.memberNameEdt1);
        memberIndexNoEdt1 = findViewById(R.id.indexNoEdt1);
        memberRegNoEdt1 = findViewById(R.id.regNoEdt1);
        memberNameEdt2 = findViewById(R.id.memberNameEdt2);
        memberIndexNoEdt2 = findViewById(R.id.indexNoEdt2);
        memberRegNoEdt2 = findViewById(R.id.regNoEdt2);
        memberNameEdt3 = findViewById(R.id.memberNameEdt3);
        memberIndexNoEdt3 = findViewById(R.id.indexNoEdt3);
        memberRegNoEdt3 = findViewById(R.id.regNoEdt3);
        memberNameEdt4 = findViewById(R.id.memberNameEdt4);
        memberIndexNoEdt4 = findViewById(R.id.indexNoEdt4);
        memberRegNoEdt4 = findViewById(R.id.regNoEdt4);
        memberNameEdt5 = findViewById(R.id.memberNameEdt5);
        memberIndexNoEdt5 = findViewById(R.id.indexNoEdt5);
        memberRegNoEdt5 = findViewById(R.id.regNoEdt5);
        addButton = findViewById(R.id.registerButton);

        dbHandler = new DBHandler_AddGroup(AddGroupLead.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = groupNameEdt.getText().toString();
                String title = titleEdt.getText().toString();
                String memberName1 = memberNameEdt1.getText().toString();
                String indexNo1 = memberIndexNoEdt1.getText().toString();
                String regNo1 = memberRegNoEdt1.getText().toString();
                String memberName2 = memberNameEdt2.getText().toString();
                String indexNo2 = memberIndexNoEdt2.getText().toString();
                String regNo2 = memberRegNoEdt2.getText().toString();
                String memberName3 = memberNameEdt3.getText().toString();
                String indexNo3 = memberIndexNoEdt3.getText().toString();
                String regNo3 = memberRegNoEdt3.getText().toString();
                String memberName4 = memberNameEdt4.getText().toString();
                String indexNo4 = memberIndexNoEdt4.getText().toString();
                String regNo4 = memberRegNoEdt4.getText().toString();
                String memberName5 = memberNameEdt5.getText().toString();
                String indexNo5 = memberIndexNoEdt5.getText().toString();
                String regNo5 = memberRegNoEdt5.getText().toString();

                if (groupName.isEmpty() && title.isEmpty() && memberName1.isEmpty() && indexNo1.isEmpty()  && regNo1.isEmpty() && memberName2.isEmpty() && indexNo2.isEmpty()  && regNo2.isEmpty() && memberName3.isEmpty() && indexNo3.isEmpty()  && regNo3.isEmpty()) {
                    Toast.makeText(AddGroupLead.this, "Please enter the necessary datas..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewGroup(groupName, title, memberName1, indexNo1, regNo1, memberName2, indexNo2, regNo2, memberName3, indexNo3, regNo3, memberName4, indexNo4, regNo4, memberName5, indexNo5, regNo5);

                Toast.makeText(AddGroupLead.this, "Group has been added.", Toast.LENGTH_SHORT).show();
                groupNameEdt.setText("");
                titleEdt.setText("");
                memberNameEdt1.setText("");
                memberIndexNoEdt1.setText("");
                memberRegNoEdt1.setText("");
                memberNameEdt2.setText("");
                memberIndexNoEdt2.setText("");
                memberRegNoEdt2.setText("");
                memberNameEdt3.setText("");
                memberIndexNoEdt3.setText("");
                memberRegNoEdt3.setText("");
                memberNameEdt4.setText("");
                memberIndexNoEdt4.setText("");
                memberRegNoEdt4.setText("");
                memberNameEdt5.setText("");
                memberIndexNoEdt5.setText("");
                memberRegNoEdt5.setText("");
            }
        });
    }
}
