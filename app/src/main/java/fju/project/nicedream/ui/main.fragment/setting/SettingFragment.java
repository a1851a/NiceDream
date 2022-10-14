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

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;
import fju.project.nicedream.ui.article.ArticleActivity;
import fju.project.nicedream.ui.vedio.VedioActivity;

public class SettingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_setting, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button share = getActivity().findViewById(R.id.share);
        Button education = getActivity().findViewById(R.id.education);
        Button account_edit = getActivity().findViewById(R.id.account_edit);
        Button article = getActivity().findViewById(R.id.article);
        Button vedio = getActivity().findViewById(R.id.vedio);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {

                }
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {

                }
            }
        });
        account_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(getActivity())){
                    return;
                }
                else {

                }
            }
        });
        article.setOnClickListener(new View.OnClickListener() {
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
        vedio.setOnClickListener(new View.OnClickListener() {
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