package com.leafmaple.androidtraining.adapter;

import android.util.Log;
import android.widget.ImageView;


import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;


import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.bean.NewsBean;
import com.leafmaple.androidtraining.utils.NetUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeAdapter extends BaseMultiItemQuickAdapter<NewsBean, BaseViewHolder> {

    public HomeAdapter(List<NewsBean> data) {
        super(data);
        // 绑定 layout 对应的 type
        addItemType(1, R.layout.item_home1);
        addItemType(2, R.layout.item_home2);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, NewsBean item) {
        Log.i("获取到的item类型",item.getItemType()+"");
        // 根据返回的 type 分别设置数据
        switch (item.getItemType()) {
            case 1:
                holder.setText(R.id.textView,item.getNewsName());
                holder.setText(R.id.textView2,item.getNewsTypeName());
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg1()).into((ImageView) holder.getView(R.id.imageView));
                break;
            case 2:
                holder.setText(R.id.textView,item.getNewsName());
                holder.setText(R.id.textView2,item.getNewsTypeName());
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg1()).into((ImageView) holder.getView(R.id.imageView));
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg2()).into((ImageView) holder.getView(R.id.imageView2));
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg3()).into((ImageView) holder.getView(R.id.imageView3));
                break;
            default:
                break;
        }
    }
}