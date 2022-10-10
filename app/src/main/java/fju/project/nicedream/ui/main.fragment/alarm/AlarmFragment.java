package fju.project.nicedream.ui.main.fragment.alarm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import fju.project.nicedream.NiceDreamApplication;
import fju.project.nicedream.R;

public class AlarmFragment extends Fragment {

    private Timer timer;
    private TimerTask timerTask;
    Double time = 0.0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button start = getActivity().findViewById(R.id.sleep_start);
        Button end = getActivity().findViewById(R.id.sleep_end);
        TextView count_time_start = getActivity().findViewById(R.id.count_time_1);
        TextView count_time_end = getActivity().findViewById(R.id.count_time_2);
        TextView sum_time = getActivity().findViewById(R.id.alarm_time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time_start.setText(""+ DateFormat.format("HH:mm:ss",System.currentTimeMillis()));
                start.setVisibility(View.INVISIBLE);
                end.setVisibility(View.VISIBLE);
                count_time_end.setText("00:00:00");
                time = 0.0;

                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                time++;
                                sum_time.setText(getTimerText());
                            }
                        });
                    }
                };
                timer = NiceDreamApplication.getTimer();
                timer.schedule(timerTask,1000,1000);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time_end.setText(""+ DateFormat.format("HH:mm:ss",System.currentTimeMillis()));
                end.setVisibility(View.INVISIBLE);
                start.setVisibility(View.VISIBLE);

                timerTask.cancel();
            }
        });

    }

    private String getTimerText(){
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);
        return formatTime(seconds, minutes, hours);
    }
    private String formatTime(int seconds, int minutes, int hours)
    {
        return String.format("%02d",hours) + " : " + String.format("%02d",minutes) + " : " + String.format("%02d",seconds);
    }
}