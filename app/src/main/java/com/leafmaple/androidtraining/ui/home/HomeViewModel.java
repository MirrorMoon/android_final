package com.leafmaple.androidtraining.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


import com.github.leonardoxh.livedatacalladapter.Resource;
import com.leafmaple.androidtraining.bean.NewsBean;
import com.leafmaple.androidtraining.utils.NetUtils;

import java.util.List;

public class HomeViewModel extends ViewModel {



    public LiveData<List<NewsBean>> getNewsList() {
        //资源转换

        return Transformations.map(NetUtils.get().getNewsList(),Resource::getResource);
    }
    public LiveData<List<NewsBean>> getAdList() {
        //资源转换
        return Transformations.map(NetUtils.get().getAdList(), Resource::getResource);
    }
}