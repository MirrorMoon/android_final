package com.leafmaple.androidtraining.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.adapter.HomeAdapter;
import com.leafmaple.androidtraining.adapter.ImageAdapter;
import com.leafmaple.androidtraining.adapter.ImageTitleNumAdapter;
import com.leafmaple.androidtraining.bean.NewsBean;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;
    private Banner<?, BannerAdapter<?,?>> banner;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =  new ViewModelProvider(this).get(HomeViewModel.class);


        View root = inflater.inflate(R.layout.fragment_home,container,false);
        RefreshLayout refreshLayout = (RefreshLayout)root.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        homeAdapter = new HomeAdapter(null);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setEmptyView(R.layout.empty_home);
        View headerView=inflater.inflate(R.layout.header_home,container,false);
        homeAdapter.addHeaderView(headerView);
        homeAdapter.setHeaderWithEmptyEnable(true);
        banner=headerView.findViewById(R.id.banner);
        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setPageTransformer(new ZoomOutPageTransformer())
                .setBannerGalleryMZ(20,0.8f)
                .start();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(R.drawable.pic_item_list_default);
        }
        banner.setAdapter(new ImageAdapter(list));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                getAdList();
                getNewsList();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                Toast.makeText(getActivity(),"没有更多数据了",Toast.LENGTH_SHORT).show();
            }
        });
        getAdList();
        getNewsList();
        LinearLayout linearLayoutPython = headerView.findViewById(R.id.linearLayout_Python);
        linearLayoutPython.setOnClickListener(v->{
            //从当前试图导航至指定视图
            Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_pythonFragment);
        });
        homeAdapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("url",homeAdapter.getData().get(position).getNewsUrl());
            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_webFragment,bundle);
        });
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void getAdList() {
        homeViewModel.getAdList().observe(getViewLifecycleOwner(), new Observer<List<NewsBean>>() {
            @Override
            public void onChanged(List<NewsBean> newsBeans) {
                banner.setAdapter(new ImageTitleNumAdapter(newsBeans));
                banner.setOnBannerListener((data,position)->{
                    Bundle bundle = new Bundle();
                    bundle.putString("url",((NewsBean)data).getNewsUrl());
                    Navigation.findNavController(banner).navigate(R.id.action_navigation_home_to_webFragment,bundle);
                });
            }
        });
    }

    private void getNewsList() {
        homeViewModel.getNewsList().observe(getViewLifecycleOwner(), new Observer<List<NewsBean>>() {
            @Override
            public void onChanged(List<NewsBean> newsBeans) {
                homeAdapter.setList(newsBeans);
            }
        });
    }



}