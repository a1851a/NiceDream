package fju.project.nicedream.ui.main.fragment.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.internal.FragmentWrapper;

import java.util.Timer;
import java.util.TimerTask;

import fju.project.nicedream.NiceDreamApplication;
import fju.project.nicedream.R;
import fju.project.nicedream.databinding.FragmentHomeBinding;
import fju.project.nicedream.ui.rapid_test.RapidtestActivity;

public class HomeFragment extends Fragment {

    private Timer timer;
    private TimerTask timerTask;
    private TextView date,time,judge_time;
    private ConstraintLayout display0,display1,display2,display3;
    private int hr;

    FragmentHomeBinding homebinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view= inflater.inflate(R.layout.fragment_home,container,false);
        homebinding =FragmentHomeBinding.inflate(inflater,container,false);

        homebinding.homeDate.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));
        homebinding.homeTime.setText(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));
        homebinding.judgeTime.setText(""+ DateFormat.format("HH",System.currentTimeMillis()));

        /*
        TextView date =(TextView) view.findViewById(R.id.home_date);
        date.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));
        TextView time =(TextView) view.findViewById(R.id.home_time);
        time.setText(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));
        TextView judge_time =(TextView) view.findViewById(R.id.judge_time);
        judge_time.setText(""+ DateFormat.format("HH",System.currentTimeMillis()));
        */

        //return view;
        return  homebinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        date = getActivity().findViewById(R.id.home_date);
                        date.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));
                        time = getActivity().findViewById(R.id.home_time);
                        time.setText(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));
                        judge_time = getActivity().findViewById(R.id.judge_time);
                        judge_time.setText(""+ DateFormat.format("HH",System.currentTimeMillis()));
                        display0 = getActivity().findViewById(R.id.constraintLayout_display0);
                        display1 = getActivity().findViewById(R.id.constraintLayout_display1);
                        display2 = getActivity().findViewById(R.id.constraintLayout_display2);
                        display3 = getActivity().findViewById(R.id.constraintLayout_display3);

                        double hr =Double.parseDouble(judge_time.getText().toString());
                        display0.setVisibility(View.INVISIBLE);
                        //5~11
                        if (hr > 4 && hr < 12){
                            display1.setVisibility(View.VISIBLE);
                            display2.setVisibility(View.INVISIBLE);
                            display3.setVisibility(View.INVISIBLE);
                        }
                        //12~22
                        else if (hr > 11 && hr < 22){
                            display1.setVisibility(View.INVISIBLE);
                            display2.setVisibility(View.VISIBLE);
                            display3.setVisibility(View.INVISIBLE);
                        }
                        else {
                            display1.setVisibility(View.INVISIBLE);
                            display2.setVisibility(View.INVISIBLE);
                            display3.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        };
        timer = NiceDreamApplication.getTimer();
        timer.schedule(timerTask,1000,1000);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView test1 =  getActivity().findViewById(R.id.test_1);
        ImageView test2 =  getActivity().findViewById(R.id.test_2);
        ImageView test3 =  getActivity().findViewById(R.id.test_3);

        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RapidtestActivity.class));
            }
        });
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RapidtestActivity.class));
            }
        });
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RapidtestActivity.class));
            }
        });
    }
}