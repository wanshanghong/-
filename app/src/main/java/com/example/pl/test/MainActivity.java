package com.example.pl.test;



import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    MyTopBar myTopBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        myTopBar = findViewById(R.id.Mytb);
        myTopBar.setOnTopbarClickListener(new topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rigthClick() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });
    }

}