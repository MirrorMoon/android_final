package com.leafmaple.androidtraining.ui.home.web;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.activity.MainActivity;
import com.leafmaple.androidtraining.base.BaseFragment2;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class WebFragment extends BaseFragment2 {
    private AgentWeb mAgentWeb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_web, container, false);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) root, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()
                .setWebChromeClient(new WebChromeClient(){
                    @Override
                    public void onReceivedTitle(WebView view, String title) {
                        super.onReceivedTitle(view, title);
                        MainActivity activity = (MainActivity) getActivity();
                        if (activity != null) {
                            ActionBar supportActionBar = activity.getSupportActionBar();
                            if (supportActionBar != null) {
                                supportActionBar.setTitle(title);
                            }
                        }

                    }
                })
                .createAgentWeb()
                .ready()
                .go(getArguments()!=null?getArguments().getString("url"):"http://www.baidu.com");
        return root;
    }
    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }
    @Override
    public void onDestroyView() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroyView();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mAgentWeb.handleKeyEvent(keyCode, event);
    }
}