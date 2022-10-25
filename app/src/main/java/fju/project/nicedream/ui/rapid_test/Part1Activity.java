package fju.project.nicedream.ui.rapid_test;

import static android.graphics.Insets.add;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.sql.SQLData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.db.SQLdata;

public class Part1Activity extends AppCompatActivity {

    public SQLdata DH = null;
    public SQLiteDatabase db;
    private String date,time;
    private String genderanswer,ageanswer,jobanswer,revenueanswer,hightanswer,weightanswer;

    @BindView(R.id.edit_name)
    TextView name;
    @BindView(R.id.spinnergender)
    Spinner gender;
    @BindView(R.id.spinnerage)
    Spinner age;
    @BindView(R.id.spinnerjob)
    Spinner job;
    @BindView(R.id.spinnerrevenue)
    Spinner revenue;
    @BindView(R.id.spinnerhight)
    Spinner hight;
    @BindView(R.id.spinnerweight)
    Spinner weight;
    @BindView(R.id.submit1)
    Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);

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
        ArrayAdapter adapter_job = ArrayAdapter.createFromResource(this,R.array.job, android.R.layout.simple_dropdown_item_1line);
        job.setAdapter(adapter_job);
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
                }
                else if("20~29".equals(age.getSelectedItem().toString())){
                    ageanswer = "20~29";
                }
                else if ("30~39".equals(age.getSelectedItem().toString())){
                    ageanswer = "30~39";
                }
                else if ("40~49".equals(age.getSelectedItem().toString())){
                    ageanswer = "40~49";
                }
                else if ("50~59".equals(age.getSelectedItem().toString())){
                    ageanswer = "50~59";
                }
                else if ("60~69".equals(age.getSelectedItem().toString())){
                    ageanswer = "60~69";
                }
                else {
                    ageanswer = "70以上";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        job.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ("學生".equals(job.getSelectedItem().toString())){
                    jobanswer = "學生";
                }
                else if("餐飲業".equals(job.getSelectedItem().toString())){
                    jobanswer = "餐飲業";
                }
                else if ("資訊業".equals(job.getSelectedItem().toString())){
                    jobanswer = "資訊業";
                }
                else if ("製造業".equals(job.getSelectedItem().toString())){
                    jobanswer = "製造業";
                }
                else if ("金融業".equals(job.getSelectedItem().toString())){
                    jobanswer = "金融業";
                }
                else if ("廣告業".equals(job.getSelectedItem().toString())){
                    jobanswer = "廣告業";
                }
                else if ("軍人".equals(job.getSelectedItem().toString())){
                    jobanswer = "軍人";
                }
                else if ("教師".equals(job.getSelectedItem().toString())){
                    jobanswer = "教師";
                }
                else if ("公務人員".equals(job.getSelectedItem().toString())){
                    jobanswer = "公務人員";
                }
                else if ("服務業".equals(job.getSelectedItem().toString())){
                    jobanswer = "服務業";
                }
                else if ("家管".equals(job.getSelectedItem().toString())){
                    jobanswer = "家管";
                }
                else {
                    jobanswer = "其他";
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
                }
                else if("540001~1210000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "540001~1210000";
                }
                else if ("1210001~2420000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "1210001~2420000";
                }
                else if ("2420001~4530000".equals(revenue.getSelectedItem().toString())){
                    revenueanswer = "2420001~4530000";
                }
                else{
                    revenueanswer = "4530001以上";
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
                }
                else if("151~160公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "151~160公分";
                }
                else if ("161~170公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "161~170公分";
                }
                else if ("171~180公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "171~180公分";
                }
                else if ("181~190公分".equals(hight.getSelectedItem().toString())){
                    hightanswer = "181~190公分";
                }
                else {
                    hightanswer = "191公分以上";
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
                }
                else if("41~50公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "41~50公斤";
                }
                else if ("51~60公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "51~60公斤";
                }
                else if ("61~70公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "61~70公斤";
                }
                else if ("71~80公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "71~80公斤";
                }
                else if ("81~90公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "81~90公斤";
                }
                else if ("91~100公斤".equals(weight.getSelectedItem().toString())){
                    weightanswer = "91~100公斤";
                }
                else {
                    weightanswer = "101公斤以上";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @OnClick(R.id.submit1)
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.submit1:
                if ("".equals(name.getText().toString().trim()) ||
                        "請選擇".equals(age.getSelectedItem().toString()) ||
                        "請選擇".equals(job.getSelectedItem().toString()) ||
                        "請選擇".equals(revenue.getSelectedItem().toString()) ||
                        "請選擇".equals(hight.getSelectedItem().toString()) ||
                        "請選擇".equals(weight.getSelectedItem().toString())
                ){
                    Toast.makeText(this,"未輸入完成",Toast.LENGTH_SHORT).show();
                }
                else {
                    add(date,time,name.getText().toString(),genderanswer,ageanswer,jobanswer,revenueanswer,hightanswer,weightanswer);
                    startActivity(new Intent(this, Part2Activity.class));
                }
                break;
        }
    }

    //增加第一部份資料
    private void add(String date,String time,String name,String genderanswer,String ageanswer,String jobanswer,String revenueanswer,String hightanswer,String weightanswer) {
        ContentValues values = new ContentValues();
        values.put("date",date);
        values.put("time",time);
        values.put("name", name);
        values.put("gender", genderanswer);
        values.put("age", ageanswer);
        values.put("job", jobanswer);
        values.put("revenue", revenueanswer);
        values.put("hight", hightanswer);
        values.put("weight", weightanswer);
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