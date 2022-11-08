package fju.project.nicedream.ui.main.fragment.record;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.resources.TextAppearance;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import fju.project.nicedream.MainActivity;
import fju.project.nicedream.R;
import fju.project.nicedream.data.db.SQLdata;
import fju.project.nicedream.ui.chart.ChartActivity;

public class RecordFragment extends Fragment {

    public SQLdata DH = null;
    public static SQLiteDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record,container,false);

        DH = new SQLdata(getActivity());
        //讀取資料庫
        db = DH.getWritableDatabase();

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

        display();

    }

    private void display(){

        ListView list = getActivity().findViewById(R.id.list);
        //查詢資料庫定載入
        Cursor cursor = db.query("test",new String[]{"date","outcome"},null,null,null,null,null);
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        cursor.moveToFirst();

        //叫出資料庫的資料
        for (int i = 0; i < cursor.getCount(); i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("date",cursor.getString(0));
            item.put("outcome",cursor.getString(1));
            items.add(item);
        }
        SimpleAdapter history = new SimpleAdapter(getActivity(),items,R.layout.list,new String[]{"date","outcome"},new int[]{R.id.date,R.id.outcome});
        list.setAdapter(history);
    }

}