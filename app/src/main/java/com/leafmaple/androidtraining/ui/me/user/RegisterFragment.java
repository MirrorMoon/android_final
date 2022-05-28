package com.leafmaple.androidtraining.ui.me.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.base.BaseFragment2;
import com.leafmaple.androidtraining.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class RegisterFragment extends BaseFragment2 {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        editText=root.findViewById(R.id.editText);
        editText2=root.findViewById(R.id.editText2);
        editText3=root.findViewById(R.id.editText3);
        Button button = root.findViewById(R.id.button);
        button.setOnClickListener(this::signUp);
        return root;
    }
    /**
     * 账号密码注册
     */
    private void signUp(final View view) {
        String name = editText.getText().toString();
        String password = editText2.getText().toString();
        String email = editText3.getText().toString();
        if(TextUtils.isEmpty(name)){
            editText.setError("帐号不可以为空");
            return;
        }
        if(TextUtils.isEmpty(password)){
            editText.setError("密码不能为空");
            return;
        }
        if(TextUtils.isEmpty(email)){
            editText.setError("邮箱不能为空");
            return;
        }
        final User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setNickName(name);
        user.setSex(true);
        user.setInfo("这家伙很懒什么都没有留下");
        user.setEmail(email);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "注册成功", Snackbar.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                } else {
                    Snackbar.make(view, "尚未失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}