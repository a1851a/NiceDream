package fju.project.nicedream.ui.rapid_test;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import fju.project.nicedream.R;

public class Part3Activity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

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

    }
}
