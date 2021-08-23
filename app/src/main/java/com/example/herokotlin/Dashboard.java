package com.example.herokotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.herokotlin.models.DashboardModel;
import com.example.herokotlin.viewmodels.DashboardViewModel;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    private TextView quotes;

    private DashboardViewModel dashboardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        quotes = findViewById(R.id.textView);

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.init();

        dashboardViewModel.runApi().observe(this, new Observer<List<DashboardModel>>() {
            @Override
            public void onChanged(List<DashboardModel> s) {
                Log.d("test2x", "s: --> "+ s);
                quotes.setText(s.toString());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dashboardViewModel.destroyLiveStream();
    }
}