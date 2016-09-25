package com.cabin.gth.cabin;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class CabinActivity extends AppCompatActivity {

    Firebase ref = new Firebase("https://cabin-49a08.firebaseio.com/");
    private ValueEventListener cabinStatus;

    ArrayList<ImageView> images = new ArrayList<ImageView>();//findViewById(R.id.)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_cabin);
        images.add((ImageView) findViewById(R.id.b11));
        images.add((ImageView) findViewById(R.id.b12));
        images.add((ImageView) findViewById(R.id.b21));
        images.add((ImageView) findViewById(R.id.b22));
        images.add((ImageView) findViewById(R.id.b31));
        images.add((ImageView) findViewById(R.id.b32));
        images.add((ImageView) findViewById(R.id.b41));
        images.add((ImageView) findViewById(R.id.b42));
        images.add((ImageView) findViewById(R.id.b51));
        images.add((ImageView) findViewById(R.id.b52));
        images.add((ImageView) findViewById(R.id.b61));
        images.add((ImageView) findViewById(R.id.b62));
        images.add((ImageView) findViewById(R.id.b71));
        images.add((ImageView) findViewById(R.id.b72));
        images.add((ImageView) findViewById(R.id.b81));
        images.add((ImageView) findViewById(R.id.b82));
        images.add((ImageView) findViewById(R.id.b91));
        images.add((ImageView) findViewById(R.id.b92));
        images.add((ImageView) findViewById(R.id.b101));
        images.add((ImageView) findViewById(R.id.b102));

            cabinStatus = ref.child("Cabin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 0;
                for (DataSnapshot snapshot :dataSnapshot.getChildren()) {
                    String[] separated = snapshot.getValue().toString().split(":");
                    if (separated[0].equals("0")) {
                        images.get(i).setImageDrawable(ContextCompat.getDrawable(CabinActivity.this, R.drawable.empty));
                    }
                    else
                        images.get(i).setImageDrawable(ContextCompat.getDrawable(CabinActivity.this, R.drawable.ic_work_black_48dp));
                    if (separated[1].equals("0"))
                        images.get(i+1).setImageDrawable(ContextCompat.getDrawable(CabinActivity.this, R.drawable.empty));
                    else
                        images.get(i+1).setImageDrawable(ContextCompat.getDrawable(CabinActivity.this, R.drawable.ic_work_black_48dp));
                    i = i + 2;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
