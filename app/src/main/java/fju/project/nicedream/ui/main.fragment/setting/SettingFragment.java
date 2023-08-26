package fju.project.nicedream.ui.main.fragment.setting;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.FacebookSdk;

import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;
import fju.project.nicedream.databinding.FragmentSettingBinding;
import fju.project.nicedream.ui.main.fragment.setting.article.ArticleActivity;
import fju.project.nicedream.ui.main.fragment.setting.education.EducationActivity;
import fju.project.nicedream.ui.main.fragment.setting.share.ShareActivity;
import fju.project.nicedream.ui.main.fragment.setting.vedio.VedioActivity;

public class SettingFragment extends Fragment {

    FragmentSettingBinding settingbinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view =inflater.inflate(R.layout.fragment_setting, container, false);
        settingbinding = FragmentSettingBinding.inflate(inflater,container,false);
       // return view;
        return settingbinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        Button share = getActivity().findViewById(R.id.share);
        Button education = getActivity().findViewById(R.id.education);
        Button article = getActivity().findViewById(R.id.article);
        Button vedio = getActivity().findViewById(R.id.vedio);
        */

        settingbinding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {
                    startActivity(new Intent(getActivity(), ShareActivity.class));
                }
            }
        });
        settingbinding.education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {
                    startActivity(new Intent(getActivity(), EducationActivity.class));
                }
            }
        });
        settingbinding.article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {
                    startActivity(new Intent(getActivity(), ArticleActivity.class));
                }
            }
        });
        settingbinding.vedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {
                    startActivity(new Intent(getActivity(), VedioActivity.class));
                }
            }
        });
    }
}