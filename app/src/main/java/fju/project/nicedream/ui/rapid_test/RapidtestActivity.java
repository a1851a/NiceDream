package fju.project.nicedream.ui.rapid_test;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.db.SQLdata;

public class RapidtestActivity extends AppCompatActivity {

    public SQLdata DH = null;
    public SQLiteDatabase db;
    private String date,time;
    //填入資料庫
    private String genderanswer,ageanswer,revenueanswer,hightanswer,weightanswer;
    private String sleepstarttimeanswer,sleeptimeanswer,activitytimeanswer,phonetimeanswer,noiseanswer,comfortableanswer;
    //計算
    private Integer agenumber,revenuenumber,hightnumber,weightnumber;
    private Integer sleepstarttimenumber,sleeptimenumber,activitytimenumber,phonetimenumber,noisenumber,comfortablenumber;
    //判斷式
    private double y1 ,y2 ,y3 ;
    private String outcome;
    @BindView(R.id.spinnergender)
    Spinner gender;
    @BindView(R.id.spinnerage)
    Spinner age;
    @BindView(R.id.spinnerrevenue)
    Spinner revenue;
    @BindView(R.id.spinnerhight)
    Spinner hight;
    @BindView(R.id.spinnerweight)
    Spinner weight;
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
    @BindView(R.id.text_tolitnumber)
    TextView text_tolitnumber;
    @BindView(R.id.seekBartolit)
    SeekBar tolit;
    @BindView(R.id.text_headachenumber)
    TextView text_headachenumber;
    @BindView(R.id.seekBarheadache)
    SeekBar headache;
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
    @BindView(R.id.text_headachenumber_progress)
    TextView text_headachenumberprogress;
    @BindView(R.id.seekBarheadache_progress)
    SeekBar headache_progress;

    @BindView(R.id.submit)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapidtest);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        DH = new SQLdata(this);
        //讀取資料庫
        db = DH.getWritableDatabase();

        date=(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));
        time=(""+ DateFormat.format("HH:mm",System.currentTimeMillis()));

        ArrayAdapter adapter_gender = ArrayAdapter.createFromResource(this,R.array.gender, android.R.layout.simple_dropdown_item_1line);
        gender.setAdapter(adapter_gender);
        ArrayAdapter adapter_age = ArrayAdapter.createFromResource(this,R.array.age, android.R.layout.simple_dropdown_item_1line);
        age.setAdapter(adapter_age);
        ArrayAdapter adapter_revenue = ArrayAdapter.createFromResource(this,R.array.revenue, android.R.layout.simple_dropdown_item_1line);
        revenue.setAdapter(adapter_revenue);
        ArrayAdapter adapter_hight = ArrayAdapter.createFromResource(this,R.array.hight, android.R.layout.simple_dropdown_item_1line);
        hight.setAdapter(adapter_hight);
        ArrayAdapter adapter_weight = ArrayAdapter.createFromResource(this,R.array.weight, android.R.layout.simple_dropdown_item_1line);
        weight.setAdapter(adapter_weight);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("請選擇".equals(gender.getSelectedItem().toString())){
                    genderanswer = "未選擇";
                }
                else if("男性".equals(gender.getSelectedItem().toString())){
                    genderanswer = "男性";
                }
                else {
                    genderanswer = "女性";
                }
                //Toast.makeText(view.getContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("19以下".equals(age.getSelectedItem().toString())){
                    ageanswer = "19以下";
                    agenumber = 5;
                }
                else if("20~29".equals(age.getSelectedItem().toString())){
                    ageanswer = "20~29";
                    agenumber = 10;
                }
                else if ("30~39".equals(age.getSelectedItem().toString())){
                    ageanswer = "30~39";
                    agenumber = 15;
                }
                else if ("40~49".equals(age.getSelectedItem().toString())){
                    ageanswer = "40~49";
                    agenumber = 20;
                }
                else if ("50~59".equals(age.getSelectedItem().toString())){
                    ageanswer = "50~59";
                    agenumber = 25;
                }
                else if ("60~69".equals(age.getSelectedItem().toString())){
                    ageanswer = "60~69";
                    agenumber = 30;
                }
                else {
                    ageanswer = "70以上";
                    agenumber = 35;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        revenue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("0~540000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "0~540000";
                    revenuenumber = 5;
                }
                else if("540001~1210000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "540001~1210000";
                    revenuenumber = 10;
                }
                else if ("1210001~2420000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "1210001~2420000";
                    revenuenumber = 15;
                }
                else if ("2420001~4530000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "2420001~4530000";
                    revenuenumber = 20;
                }
                else{
                    revenueanswer = "4530001以上";
                    revenuenumber = 25;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        hight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("150公分以下".equals(hight.getSelectedItem().toString())){
                    hightanswer = "150公分以下";
                    hightnumber = 5;
                }
                else if("151~160公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "151~160公分";
                    hightnumber = 10;
                }
                else if ("161~170公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "161~170公分";
                    hightnumber = 15;
                }
                else if ("171~180公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "171~180公分";
                    hightnumber = 20;
                }
                else if ("181~190公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "181~190公分";
                    hightnumber = 25;
                }
                else {
                    hightanswer = "191公分以上";
                    hightnumber = 30;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        weight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("40公斤以下".equals(weight.getSelectedItem().toString())){
                    weightanswer = "40公斤以下";
                    weightnumber = 5;
                }
                else if("41~50公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "41~50公斤";
                    weightnumber = 10;
                }
                else if ("51~60公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "51~60公斤";
                    weightnumber = 15;
                }
                else if ("61~70公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "61~70公斤";
                    weightnumber = 20;
                }
                else if ("71~80公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "71~80公斤";
                    weightnumber = 25;
                }
                else if ("81~90公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "81~90公斤";
                    weightnumber = 30;
                }
                else if ("91~100公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "91~100公斤";
                    weightnumber = 35;
                }
                else {
                    weightanswer = "101公斤以上";
                    weightnumber = 40;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sleepstarttime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("9點前".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "9點前";
                    sleepstarttimenumber = 5;
                }
                else if("9~10點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "9~10點";
                    sleepstarttimenumber = 10;
                }
                else if("10~11點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "10~11點";
                    sleepstarttimenumber = 15;
                }
                else if("11~12點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "11~12點";
                    sleepstarttimenumber = 20;
                }
                else if("12~1點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "12~1點";
                    sleepstarttimenumber = 25;
                }
                else if("1~2點".equals(sleepstarttime.getSelectedItem().toString())){
                    sleepstarttimeanswer = "1~2點";
                    sleepstarttimenumber = 30;
                }
                else {
                    sleepstarttimeanswer = "2點後";
                    sleepstarttimenumber = 35;
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
                    sleeptimenumber = 5;
                }
                else if("4~6小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "4~6小時";
                    sleeptimenumber = 10;
                }
                else if("6~8小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "6~8小時";
                    sleeptimenumber = 15;
                }
                else if("8~10小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "8~10小時";
                    sleeptimenumber = 20;
                }
                else if("10~12小時".equals(sleeptime.getSelectedItem().toString())){
                    sleeptimeanswer = "10~12小時";
                    sleeptimenumber = 25;
                }
                else {
                    sleeptimeanswer = "超過12小時";
                    sleeptimenumber = 30;
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
                    activitytimenumber = 5;
                }
                else if("8~9小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "8~9小時";
                    activitytimenumber = 10;
                }
                else if("9~10小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "9~10小時";
                    activitytimenumber = 15;
                }
                else if("10~11小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "10~11小時";
                    activitytimenumber = 20;
                }
                else if("11~12小時".equals(activitytime.getSelectedItem().toString())){
                    activitytimeanswer = "11~12小時";
                    activitytimenumber = 25;
                }
                else {
                    activitytimeanswer = "超過12小時";
                    activitytimenumber = 30;
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
                    phonetimenumber = 5;
                }
                else if("30~60分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "30~60分鐘";
                    phonetimenumber = 10;
                }
                else if("60~90分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "60~90分鐘";
                    phonetimenumber = 15;
                }
                else if("90~120分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "90~120分鐘";
                    phonetimenumber = 20;
                }
                else if("120~150分鐘".equals(phonetime.getSelectedItem().toString())){
                    phonetimeanswer = "120~150分鐘";
                    phonetimenumber = 25;
                }
                else {
                    phonetimeanswer = "超過150分鐘";
                    phonetimenumber = 30;
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
                    noisenumber = 5;
                }
                else if("安靜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "安靜";
                    noisenumber = 10;
                }
                else if("一點點安靜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "一點點安靜";
                    noisenumber = 15;
                }
                else if("一點點吵雜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "一點點吵雜";
                    noisenumber = 20;
                }
                else if("吵雜".equals(noise.getSelectedItem().toString())){
                    noiseanswer = "吵雜";
                    noisenumber = 25;
                }
                else {
                    noiseanswer = "非常吵雜";
                    noisenumber = 30;
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
                    comfortablenumber = 5;
                }
                else if("硬".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "硬";
                    comfortablenumber = 10;
                }
                else if("稍微硬".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "稍微硬";
                    comfortablenumber = 15;
                }
                else if("稍微軟".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "稍微軟";
                    comfortablenumber = 20;
                }
                else if("軟".equals(comfortable.getSelectedItem().toString())){
                    comfortableanswer = "軟";
                    comfortablenumber = 25;
                }
                else {
                    comfortableanswer = "非常軟";
                    comfortablenumber = 30;
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

        headache_progress.setProgress(1);
        text_headachenumberprogress.setText("1");

        headache_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_headachenumberprogress.setText(Integer.toString(progress));
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
        text_acholicnumber.setText("1");

        acholic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_acholicnumber.setText(Integer.toString(progress));
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

    }

    @OnClick(R.id.submit)
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.submit:
                if ("請選擇".equals(age.getSelectedItem().toString()) ||
                        "請選擇".equals(revenue.getSelectedItem().toString()) ||
                        "請選擇".equals(hight.getSelectedItem().toString()) ||
                        "請選擇".equals(weight.getSelectedItem().toString()) ||
                        "請選擇".equals(sleepstarttime.getSelectedItem().toString()) ||
                        "請選擇".equals(sleeptime.getSelectedItem().toString()) ||
                        "請選擇".equals(activitytime.getSelectedItem().toString()) ||
                        "請選擇".equals(phonetime.getSelectedItem().toString()) ||
                        "請選擇".equals(noise.getSelectedItem().toString()) ||
                        "請選擇".equals(comfortable.getSelectedItem().toString())
                ){
                    Toast.makeText(this,"未輸入完成",Toast.LENGTH_SHORT).show();
                }
                else {
                    if ("未選擇".equals(genderanswer)){
                        y1 = 0.095767611 * agenumber+
                                0.11736077 * revenuenumber- 0.003463014 * hightnumber +
                                0.207174598 * weightnumber + 0.683639494 * sleepstarttimenumber -
                                0.054416414 * sleeptimenumber - 0.122161160 * activitytimenumber +
                                0.013192798 * phonetimenumber + 0.226161730 * noisenumber +
                                0.321232365 * comfortablenumber + 5 * 0.200695217 * Integer.valueOf(text_tirednumber.getText().toString()) +
                                5 * 0.13810212 * Integer.valueOf(text_headachenumber.getText().toString()) + 5 * 0.112698437 * Integer.valueOf(text_tolitnumber.getText().toString()) +
                                5 * 0.2558078 * Integer.valueOf(text_headachenumberprogress.getText().toString()) - 5 * 0.062332913 * Integer.valueOf(text_lazynumber.getText().toString()) -
                                5 * 0.062930422 * Integer.valueOf(text_dreamnumber.getText().toString()) - 5 * 0.32058528 * Integer.valueOf(text_acholicnumber.getText().toString()) -
                                5 * 0.185663247 * Integer.valueOf(text_drynumber.getText().toString()) + 5 * 0.108536251 * Integer.valueOf(text_attentionnumber.getText().toString());

                        if (y1 <= 34.95557){
                            outcome = "否";
                        }
                        else {
                            outcome="是";
                        }
                    }
                    else if ("男性".equals(genderanswer)){
                        y2 = 0.09059699 * agenumber - 0.03676339 * revenuenumber -
                                0.01908419 * hightnumber + 0.37966344 * weightnumber +
                                0.69927958 * sleepstarttimenumber - 0.06674871 * sleeptimenumber -
                                0.05892681 * activitytimenumber - 0.04100488 * phonetimenumber+
                                0.28362781 * noisenumber - 0.1207611 * comfortablenumber +
                                5 * 0.16066278 * Integer.valueOf(text_tirednumber.getText().toString()) - 5 * 0.13924082 * Integer.valueOf(text_headachenumber.getText().toString()) +
                                5 * 0.13720647 * Integer.valueOf(text_tolitnumber.getText().toString()) + 5 * 0.40881138 * Integer.valueOf(text_headachenumberprogress.getText().toString()) +
                                5 * 0.08932488 * Integer.valueOf(text_dreamnumber.getText().toString()) - 5 * 0.40881138 * Integer.valueOf(text_drynumber.getText().toString());

                        if (y2 <= 35.17268){
                            outcome = "否";
                        }
                        else {
                            outcome="是";
                        }
                    }
                    else if ("女性".equals(genderanswer)){
                        y3 = 0.74920566 * sleepstarttimenumber + 0.61270342 * comfortablenumber+
                                5 * 0.22842975 * Integer.valueOf(text_headachenumber.getText().toString()) + 5 * 0.08697056 * Integer.valueOf(text_tolitnumber.getText().toString()) +
                                5 * 0.05950947 * Integer.valueOf(text_attentionnumber.getText().toString());

                        if (y3 <= 36.34173){
                            outcome = "否";
                        }
                        else {
                            outcome="是";
                        }
                    }

                    add(date,time,genderanswer,ageanswer,revenueanswer,hightanswer,weightanswer
                            ,sleepstarttimeanswer,sleeptimeanswer,activitytimeanswer,phonetimeanswer,noiseanswer,comfortableanswer
                            ,text_tirednumber.getText().toString(),text_tolitnumber.getText().toString(),text_headachenumber.getText().toString(),text_lazynumber.getText().toString(),text_dreamnumber.getText().toString(),text_acholicnumber.getText().toString(),text_drynumber.getText().toString(),text_attentionnumber.getText().toString(),text_headachenumberprogress.getText().toString(),outcome);


                    Intent intent = new Intent();
                    intent.setClass(RapidtestActivity.this,JudgeActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("outcome",outcome);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                    this.finish();
                }
                break;
        }
    }

    //增加資料
    private void add(String date,String time,String genderanswer,String ageanswer,String revenueanswer,String hightanswer,String weightanswer,
                     String sleepstarttimeanswer,String sleeptimeanswer,String activitytimeanswer,String phonetimeanswer,String noiseanswer,String comfortableanswer,
                     String text_tirednumber,String text_tolitnumber,String text_headachenumber,String text_lazynumber,String text_dreamnumber,String text_acholicnumber,String text_drynumber,String text_attentionnumber,String text_headachenumberprogress,String outcome) {
        ContentValues values = new ContentValues();

        values.put("date",date);
        values.put("time",time);
        values.put("gender", genderanswer);
        values.put("age", ageanswer);
        values.put("revenue", revenueanswer);
        values.put("hight", hightanswer);
        values.put("weight", weightanswer);
        values.put("starttime", sleepstarttimeanswer);
        values.put("sumtime", sleeptimeanswer);
        values.put("activitytime", activitytimeanswer);
        values.put("phonetime", phonetimeanswer);
        values.put("noise", noiseanswer);
        values.put("comfortable", comfortableanswer);
        values.put("tired", text_tirednumber);
        values.put("toilt", text_tolitnumber);
        values.put("headache", text_headachenumber);
        values.put("lazy", text_lazynumber);
        values.put("dream", text_dreamnumber);
        values.put("acholic", text_acholicnumber);
        values.put("dry", text_drynumber);
        values.put("attention", text_attentionnumber);
        values.put("headacheprogress", text_headachenumberprogress);
        values.put("outcome", outcome);

        db.insert("test",null,values);
    }
}