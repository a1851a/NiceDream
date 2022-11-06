package fju.project.nicedream.ui.main.fragment.record;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.resources.TextAppearance;

import butterknife.BindView;
import fju.project.nicedream.R;
import fju.project.nicedream.ui.chart.ChartActivity;

public class RecordFragment extends Fragment {

    public String date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView sleep_line =  getActivity().findViewById(R.id.sleep_line);

        sleep_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChartActivity.class));
            }
        });
       // CalendarView calendarView = getActivity().findViewById(R.id.calendarView);

        //監聽當日期改變
       /* calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view,
                                            int year, int month, int dayOfMonth) {

                //Month從0算起
                if (dayOfMonth-10 < 0){
                    date = year + "/" + (month+1) + "/0" + dayOfMonth;
                }
                else {
                    date = year + "/" + (month+1) + "/0" + dayOfMonth;
                }

                Toast.makeText(getActivity().getApplication(), date, Toast.LENGTH_SHORT).show();

            }
        });*/
    }

}