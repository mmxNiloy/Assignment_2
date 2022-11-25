package com.mmx.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {
    private FirebaseDatabase db;
    private DatabaseReference mRef;
    private RecyclerView rv;
    private List<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        db = FirebaseDatabase.getInstance();
        mRef = db.getReference("users");
        rv = this.findViewById(R.id.rv_view_data);

        data = new ArrayList<>();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataModel value = snapshot.getValue(DataModel.class);
                Log.d("Retrieval", snapshot.toString());

                data.add(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Failed to read value.", error.toString());
            }
        });

        rv.setAdapter(new RVAdapter(data));
        rv.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
}