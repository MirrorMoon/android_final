package com.leafmaple.androidtraining.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.bean.PythonBean;

import java.util.List;

public class PythonAdapter extends BaseQuickAdapter<PythonBean, BaseViewHolder> {


    public PythonAdapter(@Nullable List<PythonBean> data) {
        super(R.layout.item_python, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, PythonBean pythonBean) {
        holder.setText(R.id.textView,pythonBean.getAddress());
        holder.setText(R.id.textView2,pythonBean.getContent());
        holder.setText(R.id.textView3,pythonBean.getOpen_class());
    }
}
