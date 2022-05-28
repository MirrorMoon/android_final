package com.leafmaple.androidtraining.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.baidu.location.LocationClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.base.OnFragmentKeyDownListener;
import com.leafmaple.androidtraining.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
    long exitTime;
    private List<OnFragmentKeyDownListener> onFragmentKeyDownListeners = new ArrayList<>();
    public void setOnFragmentKeyDownListeners(OnFragmentKeyDownListener onFragmentKeyDownListener){
        onFragmentKeyDownListeners.add(onFragmentKeyDownListener);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LocationClient.setAgreePrivacy(true);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_chart, R.id.navigation_video,R.id.navigation_home)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if(onFragmentKeyDownListeners.size()>0){
            //出栈
            onFragmentKeyDownListeners.remove(onFragmentKeyDownListeners.size()-1);
        }
        return NavigationUI.navigateUp(navController,appBarConfiguration);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN&&keyCode==KeyEvent.KEYCODE_BACK){
            if(onFragmentKeyDownListeners.size()!=0){
                //二级事件
                //判断当前键盘事件的真值
                if(onFragmentKeyDownListeners.get(onFragmentKeyDownListeners.size()-1)
                        .onKeyDown(keyCode,event)){
                    //如果为真则代表事件被处理完，上级无需处理
                    return true;
                }else{
                    onSupportNavigateUp();
                }
            }else if((System.currentTimeMillis()-exitTime)>2000){
                Toast.makeText(this,"再按一次返回键推出程序",Toast.LENGTH_SHORT).show();
                exitTime=System.currentTimeMillis();
            }else{
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
//                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}