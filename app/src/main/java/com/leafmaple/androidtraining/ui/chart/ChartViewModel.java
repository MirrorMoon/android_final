package com.leafmaple.androidtraining.ui.chart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.bean.BoomMenuItemBean;

import java.util.ArrayList;
import java.util.List;

public class ChartViewModel extends ViewModel {

    private  MutableLiveData<List<BoomMenuItemBean>> boomMenuItems;

    public ChartViewModel() {
        String[] texts={"Java","PHP","Android","黑马程序员.Python",
                "黑马程序员.C/C++","黑马程序员.iOS","黑马程序员.前端与移动开发",
                "黑马程序员.UI设计","黑马程序员.网络营销"};
        int[] imageId={R.drawable.bat, R.drawable.bear,R.drawable.bee,
                R.drawable.butterfly,R.drawable.cat,R.drawable.dolphin,R.drawable.eagle,
                R.drawable.horse,R.drawable.elephant};
        boomMenuItems = new MutableLiveData<>();
        List<BoomMenuItemBean> list= new ArrayList<>();
        for (int i = 0; i < texts.length; i++) {
            list.add(new BoomMenuItemBean(texts[i],imageId[i]));
        }
        boomMenuItems.setValue(list);
    }
    public LiveData<List<BoomMenuItemBean>> getBoomMenuItemList(){
        return boomMenuItems;
    }
}