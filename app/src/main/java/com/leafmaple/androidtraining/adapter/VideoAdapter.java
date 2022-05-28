package com.leafmaple.androidtraining.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.bean.VideoBean;
import com.leafmaple.androidtraining.utils.NetUtils;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {

    public VideoAdapter(@Nullable List<VideoBean> data) {
        super(R.layout.item_video, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, VideoBean videoBean) {
        Glide.with(getContext()).load(NetUtils.BASE_URL+videoBean.getImg())
                .into((ImageView) holder.getView(R.id.imageView))
        ;
    }
}
