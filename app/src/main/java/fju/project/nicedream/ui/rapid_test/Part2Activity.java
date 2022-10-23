package fju.project.nicedream.ui.rapid_test;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
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

public class Part2Activity extends AppCompatActivity {

    private String date2;

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


        date2=(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));

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
                    startActivity(new Intent(this, Part3Activity.class));
                }
                break;
        }
    }

}
