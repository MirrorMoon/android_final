package com.leafmaple.androidtraining.ui.video;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.github.leonardoxh.livedatacalladapter.Resource;
import com.leafmaple.androidtraining.bean.VideoBean;
import com.leafmaple.androidtraining.utils.NetUtils;

import java.util.List;

public class VideoViewModel extends ViewModel {


    public LiveData<List<VideoBean>> getVideoList() {
        return Transformations.map(NetUtils.get().getVideoList(), Resource::getResource);
    }
}