package com.leafmaple.androidtraining.ui.home.python;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.adapter.PythonAdapter;
import com.leafmaple.androidtraining.base.BaseFragment2;

public class PythonFragment extends BaseFragment2 {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //找到视图根
        View root = inflater.inflate(R.layout.fragment_python, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(),DividerItemDecoration.VERTICAL));
        PythonAdapter pythonAdapter = new PythonAdapter(null);
        recyclerView.setAdapter(pythonAdapter);
        PythonViewModel pythonViewModel = new ViewModelProvider(this).get(PythonViewModel.class);
        pythonViewModel.getPythonList().observe(getViewLifecycleOwner(),pythonBeans -> {
            Log.i("pythonBean对象",pythonBeans.get(0).toString());
            pythonAdapter.setList(pythonBeans);
        });
        return root;
    }

}