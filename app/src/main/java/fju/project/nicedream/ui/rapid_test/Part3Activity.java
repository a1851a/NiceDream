package fju.project.nicedream.ui.rapid_test;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.db.SQLdata;

public class Part3Activity extends AppCompatActivity {

    public SQLdata DH = null;
    public SQLiteDatabase db;
    private String historyanswer,yourhistoryanswer,pressureanswer,headanswer,druganswer,surgeryanswer;

    @BindView(R.id.text_tolitnumber)
    TextView text_tolitnumber;
    @BindView(R.id.seekBartolit)
    SeekBar tolit;
    @BindView(R.id.text_headachenumber)
    TextView text_headachenumber;
    @BindView(R.id.seekBarheadache)
    SeekBar headache;
    @BindView(R.id.text_shakenumber)
    TextView text_shakenumber;
    @BindView(R.id.seekBarshake)
    SeekBar shake;
    @BindView(R.id.text_lazynumber)
    TextView text_lazynumber;
    @BindView(R.id.seekBarlazy)
    SeekBar lazy;
    @BindView(R.id.text_dreamnumber)
    TextView text_dreamnumber;
    @BindView(R.id.seekBardream)
    SeekBar dream;
    @BindView(R.id.text_acholicnumber)
    TextView text_acholicnumber;
    @BindView(R.id.seekBaracholic)
    SeekBar acholic;
    @BindView(R.id.text_drynumber)
    TextView text_drynumber;
    @BindView(R.id.seekBardry)
    SeekBar dry;
    @BindView(R.id.text_attentionnumber)
    TextView text_attentionnumber;
    @BindView(R.id.seekBarattention)
    SeekBar attention;
    @BindView(R.id.spinnerhistory)
    Spinner history;
    @BindView(R.id.spinneryourhistory)
    Spinner yourhistory;
    @BindView(R.id.spinnerpressure)
    Spinner pressure;
    @BindView(R.id.spinnerhead)
    Spinner head;
    @BindView(R.id.spinnerdrug)
    Spinner drug;
    @BindView(R.id.spinnersurgery)
    Spinner surgery;
    @BindView(R.id.submit3)
    Button submit3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        DH = new SQLdata(this);
        //讀取資料庫
        db = DH.getWritableDatabase();

        tolit.setProgress(1);
        text_tolitnumber.setText("1");

        tolit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_tolitnumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        headache.setProgress(1);
        text_headachenumber.setText("1");

        headache.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_headachenumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        shake.setProgress(1);
        text_shakenumber.setText("1");

        shake.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_shakenumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        lazy.setProgress(1);
        text_lazynumber.setText("1");

        lazy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_lazynumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        dream.setProgress(1);
        text_dreamnumber.setText("1");

        dream.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_dreamnumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        acholic.setProgress(1);
        text_tolitnumber.setText("1");

        acholic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_tolitnumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        dry.setProgress(1);
        text_drynumber.setText("1");

        dry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_drynumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        attention.setProgress(1);
        text_attentionnumber.setText("1");

        attention.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_attentionnumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        history.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(history.getSelectedItem().toString())){
                    historyanswer = "有";
                }
                else {
                    historyanswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        yourhistory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(yourhistory.getSelectedItem().toString())){
                    yourhistoryanswer = "有";
                }
                else {
                    yourhistoryanswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        pressure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(pressure.getSelectedItem().toString())){
                    pressureanswer = "有";
                }
                else {
                    pressureanswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        head.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(head.getSelectedItem().toString())){
                    headanswer = "有";
                }
                else {
                    headanswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        drug.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(drug.getSelectedItem().toString())){
                    druganswer = "有";
                }
                else {
                    druganswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        surgery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("有".equals(surgery.getSelectedItem().toString())){
                    surgeryanswer = "有";
                }
                else {
                    surgeryanswer = "無";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @OnClick(R.id.submit3)
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.submit3:
                if ("請選擇".equals(history.getSelectedItem().toString()) ||
                        "請選擇".equals(yourhistory.getSelectedItem().toString()) ||
                        "請選擇".equals(pressure.getSelectedItem().toString()) ||
                        "請選擇".equals(head.getSelectedItem().toString()) ||
                        "請選擇".equals(drug.getSelectedItem().toString()) ||
                        "請選擇".equals(surgery.getSelectedItem().toString())
                ){
                    Toast.makeText(this,"未輸入完成",Toast.LENGTH_SHORT).show();
                }
                else {
                    add(Integer.valueOf(text_tolitnumber.toString()),Integer.valueOf(text_headachenumber.toString()),Integer.valueOf(text_shakenumber.toString()),Integer.valueOf(text_lazynumber.toString()),Integer.valueOf(text_dreamnumber.toString()),Integer.valueOf(text_acholicnumber.toString()),Integer.valueOf(text_drynumber.toString()),Integer.valueOf(text_attentionnumber.toString()),historyanswer,yourhistoryanswer,pressureanswer,headanswer,druganswer,surgeryanswer);
                    startActivity(new Intent(this, JudgeActivity.class));
                }
                break;
        }
    }

    //增加第三部份資料
    private void add(Integer text_tolitnumber,Integer text_headachenumber,Integer text_shakenumber,Integer text_lazynumber,Integer text_dreamnumber,Integer text_acholicnumber,Integer text_drynumber,Integer text_attentionnumber,String historyanswer,String yourhistoryanswer,String pressureanswer,String headanswer,String druganswer,String surgeryanswer) {
        ContentValues values = new ContentValues();
        values.put("toilt",text_tolitnumber);
        values.put("headache",text_headachenumber);
        values.put("shake", text_shakenumber);
        values.put("lazy", text_lazynumber);
        values.put("dream", text_dreamnumber);
        values.put("acholic", text_acholicnumber);
        values.put("dry", text_drynumber);
        values.put("attention", text_attentionnumber);
        values.put("history", historyanswer);
        values.put("yourhistory", yourhistoryanswer);
        values.put("pressure", pressureanswer);
        values.put("head", headanswer);
        values.put("drug", druganswer);
        values.put("surgery", surgeryanswer);
        db.insert("test",null,values);
    }

    //禁止使用返回鍵
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
        }
        return false;
    }
}
