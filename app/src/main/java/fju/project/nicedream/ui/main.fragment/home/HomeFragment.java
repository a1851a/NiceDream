package fju.project.nicedream.ui.main.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import fju.project.nicedream.NiceDreamApplication;
import fju.project.nicedream.R;

public class HomeFragment extends Fragment {

    private Timer timer;
    private TimerTask timerTask;
    private TextView date;
    private TextView time;
    private String hr;
    private ConstraintLayout display1,display2,display3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        TextView date =(TextView) view.findViewById(R.id.home_date);
        date.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));

        TextView time =(TextView) view.findViewById(R.id.home_time);
        time.setText(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));

        ConstraintLayout display1 = (ConstraintLayout) view.findViewById(R.id.constraintLayout_display1);
        ConstraintLayout display2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout_display2);
        ConstraintLayout display3 = (ConstraintLayout) view.findViewById(R.id.constraintLayout_display3);

        return view;
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
                    }
                });
            }
        };
        timer = NiceDreamApplication.getTimer();
        timer.schedule(timerTask,1000,1000);
    }


}