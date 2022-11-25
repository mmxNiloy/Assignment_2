package com.mmx.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private Button btnShow;
    private EditText etName;
    private EditText etID;
    private String name;
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = this.findViewById(R.id.btn_add);
        btnShow = this.findViewById(R.id.btn_show);
        etName = this.findViewById(R.id.et_name);
        etID = this.findViewById(R.id.et_id);

        btnShow.setOnClickListener(v -> {
            Intent intent = new Intent(this.getApplicationContext(), ShowDataActivity.class);
            startActivity(intent);
        });

        btnAdd.setOnClickListener(v -> {
            name = etName.getText().toString().trim();
            ID = etID.getText().toString().trim();

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference mRef = db.getReference("users");

            mRef.child(ID).setValue(name);
        });
    }
}