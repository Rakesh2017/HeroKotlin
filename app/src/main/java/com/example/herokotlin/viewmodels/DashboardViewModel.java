package com.example.herokotlin.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.herokotlin.Dashboard;
import com.example.herokotlin.models.DashboardModel;
import com.example.herokotlin.repostories.DashboardRepository;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardViewModel extends ViewModel {

   private MutableLiveData<List<DashboardModel>> listMutableLiveData;
   private DashboardRepository dashboardRepository;

   public void init() {
       if (listMutableLiveData != null) return;
       dashboardRepository = new DashboardRepository().getInstance();
       listMutableLiveData = dashboardRepository.runAPI();
   }

   public MutableLiveData<List<DashboardModel>> runApi() {
       return listMutableLiveData;
   }

   public void destroyLiveStream() {
       if (listMutableLiveData != null) {
           listMutableLiveData = null;
           dashboardRepository.destroyInstance();
       }
   }

}
