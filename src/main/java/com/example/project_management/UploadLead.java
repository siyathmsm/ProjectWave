package com.example.project_management;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class UploadLead extends AppCompatActivity {
    private EditText groupNameLbl, feedbackIteLbl, docLbl;
    private DBHandler_UnSigned dbHandler;
    private Button addButton;
    private static final int PICK_PDF_REQUEST_CODE = 123;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_doc_leader);

        // Request storage permissions if not granted
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_REQUEST_CODE);
        }

        // initializing all our variables.
        groupNameLbl = findViewById(R.id.groupNameEdt);
        feedbackIteLbl = findViewById(R.id.feedbackIteEdt);
       // docLbl = findViewById(R.id.docLbl); // This is assuming you have an EditText with id "docLbl"
        addButton = findViewById(R.id.uploadButton);

        dbHandler = new DBHandler_UnSigned(UploadLead.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = groupNameLbl.getText().toString();
                String feedbackIte = feedbackIteLbl.getText().toString();

                if (groupName.isEmpty() || feedbackIte.isEmpty()) {
                    Toast.makeText(UploadLead.this, "Please enter all the data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Upload document to the database
                dbHandler.uploadDocument(groupName, feedbackIte);

                Toast.makeText(UploadLead.this, "Document has been uploaded.", Toast.LENGTH_SHORT).show();
                groupNameLbl.setText("");
                feedbackIteLbl.setText("");
            }
        });
    }

    // Handle the click event for the "Select PDF Document" button
    public void onSelectPdfClicked(View view) {
        // Launch document picker
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        startActivityForResult(intent, PICK_PDF_REQUEST_CODE);
    }

    // Handle the result of the document picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedPdfUri = data.getData();
            // Use the selected PDF URI as the document path
            String pdfPath = selectedPdfUri.toString();
            docLbl.setText(pdfPath); // Set the document path in EditText
        }
    }

    // Method to get the file name from a URI
    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String fileName = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    fileName = cursor.getString(cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DISPLAY_NAME));
                }
            }
        }
        if (fileName == null) {
            fileName = uri.getPath();
            int index = fileName.lastIndexOf("/");
            if (index != -1) {
                fileName = fileName.substring(index + 1);
            }
        }
        return fileName;
    }

    // Handle permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with your functionality
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Permission denied. Cannot access storage.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
