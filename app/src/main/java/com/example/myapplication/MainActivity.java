package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(v -> {
            changeFragment(new FirstFragment());
        });
        btn2.setOnClickListener(v -> {
            changeFragment(new SecondFragment());
        });
    }
    public void changeFragment(Fragment f) {
        // транзакция
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainerView, f);
        ft.addToBackStack(null);
        ft.commit();
    }

}