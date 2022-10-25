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

import java.nio.charset.StandardCharsets;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.db.SQLdata;

public class Part2Activity extends AppCompatActivity {

    public SQLdata DH = null;
    public SQLiteDatabase db;
    private String sleepstarttimeanswer,sleeptimeanswer,activitytimeanswer,phonetimeanswer,noiseanswer,comfortableanswer;

    @BindView(R.id.spinnersleepstarttime)
    Spinner sleepstarttime;
    @BindView(R.id.spinnersleeptime)
    Spinner sleeptime;
    @BindView(R.id.spinneractivitytime)
    Spinner activitytime;
    @BindView(R.id.spinnerphonetime)
    Spinner phonetime;
    @BindView(R.id.spinnernoise)
    Spinner noise;
    @BindView(R.id.spinnercomfortable)
    Spinner comfortable;
    @BindView(R.id.text_tirednumber)
    TextView text_tirednumber;
    @BindView(R.id.seekBartired)
    SeekBar tired;
    @BindView(R.id.submit2)
    Button submit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        DH = new SQLdata(this);
        //讀取資料庫
        db = DH.getWritableDatabase();

        sleepstarttime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("9點前".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "9點前";
                }
                else if("9~10點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "9~10點";
                }
                else if("10~11點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "10~11點";
                }
                else if("11~12點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "11~12點";
                }
                else if("12~1點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "12~1點";
                }
                else if("1~2點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "1~2點";
                }
                else {
                    sleepstarttimeanswer = "2點後";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sleeptime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("少於4小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "少於4小時";
                }
                else if("4~6小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "4~6小時";
                }
                else if("6~8小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "6~8小時";
                }
                else if("8~10小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "8~10小時";
                }
                else if("10~12小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "10~12小時";
                }
                else {
                    sleeptimeanswer = "超過12小時";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        activitytime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("少於8小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "少於8小時";
                }
                else if("8~9小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "8~9小時";
                }
                else if("9~10小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "9~10小時";
                }
                else if("10~11小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "10~11小時";
                }
                else if("11~12小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "11~12小時";
                }
                else {
                    activitytimeanswer = "超過12小時";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        phonetime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("0~30分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "0~30分鐘";
                }
                else if("30~60分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "30~60分鐘";
                }
                else if("60~90分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "60~90分鐘";
                }
                else if("90~120分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "90~120分鐘";
                }
                else if("120~150分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "120~150分鐘";
                }
                else {
                    phonetimeanswer = "超過150分鐘";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        noise.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("非常安靜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "非常安靜";
                }
                else if("安靜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "安靜";
                }
                else if("一點點安靜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "一點點安靜";
                }
                else if("一點點吵雜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "一點點吵雜";
                }
                else if("吵雜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "吵雜";
                }
                else {
                    noiseanswer = "非常吵雜";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        comfortable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("非常硬".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "非常硬";
                }
                else if("硬".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "硬";
                }
                else if("稍微硬".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "稍微硬";
                }
                else if("稍微軟".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "稍微軟";
                }
                else if("軟".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "軟";
                }
                else {
                    comfortableanswer = "非常軟";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tired.setProgress(1);
        text_tirednumber.setText("1");

        tired.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_tirednumber.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @OnClick(R.id.submit2)
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.submit2:
                if ("請選擇".equals(sleepstarttime.getSelectedItem().toString()) ||
                        "請選擇".equals(sleeptime.getSelectedItem().toString()) ||
                        "請選擇".equals(activitytime.getSelectedItem().toString()) ||
                        "請選擇".equals(phonetime.getSelectedItem().toString()) ||
                        "請選擇".equals(noise.getSelectedItem().toString()) ||
                        "請選擇".equals(comfortable.getSelectedItem().toString())
                ){
                    Toast.makeText(this,"未輸入完成",Toast.LENGTH_SHORT).show();
                }
                else {
                    add(sleepstarttimeanswer,sleeptimeanswer,activitytimeanswer,phonetimeanswer,noiseanswer,comfortableanswer,text_tirednumber.getText().toString());
                    startActivity(new Intent(this, Part3Activity.class));
                }
                break;
        }
    }

    //增加第二部份資料
    private void add(String sleepstarttimeanswer,String sleeptimeanswer,String activitytimeanswer,String phonetimeanswer,String noiseanswer,String comfortableanswer,String text_tirednumber) {
        ContentValues values = new ContentValues();
        values.put("sleepstarttime",sleepstarttimeanswer);
        values.put("sleeptime",sleeptimeanswer);
        values.put("activitytime", activitytimeanswer);
        values.put("phonetime", phonetimeanswer);
        values.put("noise", noiseanswer);
        values.put("comfortable", comfortableanswer);
        values.put("tired", text_tirednumber);
        db.insert("test2",null,values);
    }

    //禁止使用返回鍵
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
        }
        return false;
    }
}
