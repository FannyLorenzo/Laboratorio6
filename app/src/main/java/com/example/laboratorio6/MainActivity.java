package com.example.laboratorio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.laboratorio6.ui.dashboard.DashboardFragment;
import com.example.laboratorio6.ui.home.HomeFragment;
import com.example.laboratorio6.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.botton_navigation);
        navView.setOnNavigationItemSelectedListener(navlistener);
    }
        private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectFragment = new HomeFragment();
                        break;
                    case R.id.navigation_dashboard:
                        selectFragment = new DashboardFragment();
                        break;
                    case R.id.navigation_notifications:
                        selectFragment = new NotificationsFragment();
                        break;
                }
getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
        selectFragment).commit();

                return true;
            }
        };


    }
