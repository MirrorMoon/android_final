package com.leafmaple.androidtraining.ui.me.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.base.BaseFragment2;
import com.leafmaple.androidtraining.bean.User;

import cn.bmob.v3.BmobUser;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class InfoFragment extends BaseFragment2 {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        TextView textView = root.findViewById(R.id.textView);
        TextView textView2 = root.findViewById(R.id.textView2);
        TextView textView3 = root.findViewById(R.id.textView3);
        TextView textView4 = root.findViewById(R.id.textView4);
        TextView textView5 = root.findViewById(R.id.textView5);
        if(BmobUser.isLogin()){
            User user = BmobUser.getCurrentUser(User.class);
            textView.setText(user.getUsername());
            textView2.setText(user.getNickName());
            textView3.setText(user.isSex()?"男":"女");
            textView4.setText(user.getEmail());
            textView5.setText(user.getInfo());
        }
        Button button = root.findViewById(R.id.button3);
        button.setOnClickListener(this::logout);
        return root;
    }

    private void logout(View view) {
        BmobUser.logOut();
        Navigation.findNavController(view).navigateUp();
        Snackbar.make(view, "登出", Snackbar.LENGTH_LONG).show();

    }
}