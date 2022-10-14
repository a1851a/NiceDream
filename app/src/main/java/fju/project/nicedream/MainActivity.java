package fju.project.nicedream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import fju.project.nicedream.data.eventbus.StringEvent;
import fju.project.nicedream.data.util.DisableSwipeViewPager;
import fju.project.nicedream.ui.main.fragment.alarm.AlarmFragment;
import fju.project.nicedream.ui.main.fragment.home.HomeFragment;
import fju.project.nicedream.ui.main.fragment.record.RecordFragment;
import fju.project.nicedream.ui.main.fragment.setting.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPagerAdapter sectionsPagerAdapter;
    private IntentFilter intentFilter;
    public static int currentFragmentPage = 0;
    //fragment
    private Fragment currentFragment;
    public static final int HOMEFRAGMENT = 0;
    public static final int AlarmFragment = 1;
    public static final int RecordFragment = 2;
    public static final int SettingFragment = 3;

    private HomeFragment homeFragment;
    private AlarmFragment alarmFragment;
    private RecordFragment recordFragment;
    private SettingFragment settingFragment;

    //buttom fix bar item count
    private static final int itemCount = 4;

    @BindView(R.id.constraintLayout_main)
    ConstraintLayout constraintLayoutMain;
    @BindView(R.id.tabLayout_main_bottomBar)
    TabLayout tabLayoutMainBottomBar;
    @BindView(R.id.viewPager_main_container)
    DisableSwipeViewPager viewPagerMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPagerMainContainer.setEnableSwipe(false);
        viewPagerMainContainer.setOffscreenPageLimit(4);
        viewPagerMainContainer.setAdapter(sectionsPagerAdapter);
        viewPagerMainContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMainBottomBar));
        tabLayoutMainBottomBar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMainContainer));
        tabLayoutMainBottomBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG, "onTabSelected:  position: " + position);
                tab.getIcon().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_IN);
                switch (position) {
                    case HOMEFRAGMENT:
                        currentFragmentPage = HOMEFRAGMENT;
                        StringEvent homeStringEvent = new StringEvent();
                        homeStringEvent.setEventCode(StringEvent.SHOW_HOME_PAGE);
                        EventBus.getDefault().post(homeStringEvent);
                        break;
                    case AlarmFragment:
                        currentFragmentPage = AlarmFragment;
                        StringEvent alarmStringEvent = new StringEvent();
                        alarmStringEvent.setEventCode(StringEvent.SHOW_ALARM_PAGE);
                        EventBus.getDefault().post(alarmStringEvent);
                        break;
                    case RecordFragment:
                        currentFragmentPage = RecordFragment;
                        StringEvent recordStringEvent = new StringEvent();
                        recordStringEvent.setEventCode(StringEvent.SHOW_RECORD_PAGE);
                        EventBus.getDefault().post(recordStringEvent);
                        break;
                    case SettingFragment:
                        currentFragmentPage = SettingFragment;
                        StringEvent settingStringEvent = new StringEvent();
                        settingStringEvent.setEventCode(StringEvent.SHOW_SETTING_PAGE);
                        EventBus.getDefault().post(settingStringEvent);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayoutMainBottomBar.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_IN);
        for (int i = 0; i < itemCount; i++) {
            TabLayout.Tab tab = tabLayoutMainBottomBar.getTabAt(i);
            if (Objects.equals(tab, null)) return;
            View customView = tab.getCustomView();
            if (Objects.equals(customView, null)) return;
            View icon = customView.findViewById(android.R.id.icon);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) icon.getLayoutParams();
            layoutParams.bottomMargin = 0;
            icon.setLayoutParams(layoutParams);
        }
        currentFragment = new Fragment();
        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                if (Objects.equals(homeFragment, null)) {
                    homeFragment =new HomeFragment();
                }
                return homeFragment;
            } else if (position == 1) {
                if (Objects.equals(alarmFragment, null)) {
                    alarmFragment = new AlarmFragment();
                }
                return alarmFragment;
            } else if (position == 2) {
                if (Objects.equals(recordFragment, null)) {
                    recordFragment = new RecordFragment();
                }
                return recordFragment;
            } else if (position == 3) {
                if (Objects.equals(settingFragment, null)) {
                    settingFragment = new SettingFragment();
                }
                return settingFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}