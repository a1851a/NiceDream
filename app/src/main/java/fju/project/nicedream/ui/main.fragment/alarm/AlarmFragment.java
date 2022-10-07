package fju.project.nicedream.ui.main.fragment.alarm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fju.project.nicedream.R;

public class AlarmFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm,container,false);

        TextView time =(TextView) view.findViewById(R.id.alarm_time);
        time.setText(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));

        return view;
    }

}