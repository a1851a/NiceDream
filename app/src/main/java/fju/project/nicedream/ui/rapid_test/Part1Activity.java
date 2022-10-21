package fju.project.nicedream.ui.rapid_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;

public class Part1Activity extends AppCompatActivity {

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
                //Toast.makeText(view.getContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        job.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        revenue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        hight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        weight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

                    startActivity(new Intent(this, Part2Activity.class));
                }
                break;
        }
    }
}