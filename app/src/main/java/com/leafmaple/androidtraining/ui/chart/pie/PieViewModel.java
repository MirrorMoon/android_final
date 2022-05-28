package com.leafmaple.androidtraining.ui.chart.pie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.leafmaple.androidtraining.base.BaseFragment2;
import com.leafmaple.androidtraining.bean.LineBean;
import com.leafmaple.androidtraining.bean.PieBean;

import java.util.ArrayList;
import java.util.List;

public class PieViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<PieBean>> pieList;

    public PieViewModel() {

        String[] salaries = new String[]{"月薪8k-15k","月薪15-30k","月薪30-100k", "月薪100k+"};
        int[] percentage = {50,25,15,10};
        pieList =new MutableLiveData<>();
        List<PieBean> list=new ArrayList<>();
        for (int i = 0; i < salaries.length; i++) {
            list.add(new PieBean(salaries[i],percentage[i]));
        }
        pieList.setValue(list);
    }
    public LiveData<List<PieBean>> getPieList(){
        return pieList;
    }
}