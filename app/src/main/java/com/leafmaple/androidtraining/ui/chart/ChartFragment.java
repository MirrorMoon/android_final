package com.leafmaple.androidtraining.ui.chart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.leafmaple.androidtraining.R;
import com.leafmaple.androidtraining.bean.BoomMenuItemBean;
import com.leafmaple.androidtraining.databinding.FragmentChartBinding;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

public class ChartFragment extends Fragment {

    private FragmentChartBinding binding;
    private ChartViewModel chartViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chartViewModel =
                new ViewModelProvider(this).get(ChartViewModel.class);

        binding = FragmentChartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BoomMenuButton bmb = (BoomMenuButton) root.findViewById(R.id.bmb);
        chartViewModel.getBoomMenuItemList().observe(getViewLifecycleOwner(),boomMenuItemBeans -> {
            for (BoomMenuItemBean boomMenuItemBean : boomMenuItemBeans) {
                TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder();
                builder.normalText(boomMenuItemBean.getTitle())
                        .normalImageRes(boomMenuItemBean.getImageId())
                        .listener(index -> {
                            switch (index){
                                case 0:
                                    Navigation.findNavController(root).navigate(
                                            R.id.action_navigation_chart_to_lineFragment
                                    );
                                    break;
                                case 1:
                                    Navigation.findNavController(root).navigate(
                                            R.id.action_navigation_chart_to_barFragment
                                    );
                                    break;
                                case 2:
                                    Navigation.findNavController(root).navigate(
                                            R.id.action_navigation_chart_to_pieFragment
                                    );
                                    break;
                            }
                        })
                ;
                bmb.addBuilder(builder);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}