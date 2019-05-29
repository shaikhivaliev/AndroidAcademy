package com.example.academytask1.ui.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.academytask1.R;
import com.example.academytask1.ui.presentation.main.MainPresenter;
import com.example.academytask1.ui.presentation.main.MainView;
import com.example.academytask1.ui.ui.devfest.DevFestFragment;
import com.example.academytask1.ui.ui.talks.TalksFragment;
import com.example.academytask1.ui.ui.more.MoreFragment;
import com.example.academytask1.ui.ui.speakers.SpeakersFragment;

public class MainActivity extends AppCompatActivity implements
        MainView {

    private BottomNavigationView mBottomMenu;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        mPresenter = new MainPresenter(this);
        mPresenter.getData();
    }


    private void initUI() {

        mBottomMenu = findViewById(R.id.bottom_bar);
        mBottomMenu.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.bottom_tab1:
                    changeFragment(new SpeakersFragment());
                    return true;
                case R.id.bottom_tab2:
                    changeFragment(new TalksFragment());
                    return true;
                case R.id.bottom_tab3:
                    changeFragment(new DevFestFragment());
                    return true;
                case R.id.bottom_tab4:
                    changeFragment(new MoreFragment());
                    return true;
            }
            return false;
        });

    }

    public void changeFragment(Fragment fragment) {

        boolean addToBackStack = getSupportFragmentManager().findFragmentById(R.id.fragment_container) != null;

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openSpeakersFragment() {
        changeFragment(new SpeakersFragment());
    }
}
