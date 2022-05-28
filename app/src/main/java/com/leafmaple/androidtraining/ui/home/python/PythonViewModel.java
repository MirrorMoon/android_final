package com.leafmaple.androidtraining.ui.home.python;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.github.leonardoxh.livedatacalladapter.Resource;
import com.leafmaple.androidtraining.bean.NewsBean;
import com.leafmaple.androidtraining.bean.PythonBean;
import com.leafmaple.androidtraining.utils.NetUtils;

import java.util.List;

public class PythonViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public LiveData<List<PythonBean>> getPythonList() {
        //资源转换
        return Transformations.map(NetUtils.get().getPythonList(), Resource::getResource);
    }
}