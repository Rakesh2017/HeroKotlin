package com.example.herokotlin.repostories;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;

import com.example.herokotlin.models.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardRepository extends BaseRepository<DashboardRepository> {

    private final List<DashboardModel> list = new ArrayList<>();

    public MutableLiveData<List<DashboardModel>> runAPI () {
        MutableLiveData<List<DashboardModel>> mutableLiveData = new MutableLiveData<>();
        list.add(new DashboardModel("rakesh", 1));
        list.add(new DashboardModel("ricky", 1));

        mutableLiveData.setValue(list);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(new DashboardModel("happy", 1));
                mutableLiveData.postValue(list);
            }
        },5000);

        return mutableLiveData;
    }

    @Override
    DashboardRepository createInstance() {
        return new DashboardRepository();
    }
}
