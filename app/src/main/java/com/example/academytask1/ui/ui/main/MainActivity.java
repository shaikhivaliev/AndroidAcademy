package com.example.academytask1.ui.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.academytask1.R;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.Screens;
import com.example.academytask1.ui.presentation.main.MainPresenter;
import com.example.academytask1.ui.presentation.main.MainView;
import com.example.academytask1.ui.ui.devfest.DevFestFragment;
import com.example.academytask1.ui.ui.talks.TalksFragment;
import com.example.academytask1.ui.ui.more.MoreFragment;
import com.example.academytask1.ui.ui.speakers.SpeakersFragment;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class MainActivity extends MvpAppCompatActivity implements
        MainView {

    private BottomNavigationView mBottomMenu;

    private Navigator mNavigator = new SupportAppNavigator(this, R.id.fragment_container){
        @Override
        public void applyCommands(Command[] commands) {
            super.applyCommands(commands);
        }
    };

    @InjectPresenter
    public MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            AppDelegate.getInstance().getRouter().navigateTo(Screens.SpeakersScreen);
            mPresenter.getData();
        }

        initUI();
    }

    private void initUI() {

        mBottomMenu = findViewById(R.id.bottom_bar);
        mBottomMenu.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.bottom_tab1:
                    AppDelegate.getInstance().getRouter().navigateTo(Screens.SpeakersScreen);
                    return true;
                case R.id.bottom_tab2:
                    AppDelegate.getInstance().getRouter().navigateTo(Screens.TalksScreen);
                    return true;
                case R.id.bottom_tab3:
                    AppDelegate.getInstance().getRouter().navigateTo(Screens.DevFestScreen);
                    return true;
                case R.id.bottom_tab4:
                    AppDelegate.getInstance().getRouter().navigateTo(Screens.MoreScreen);
                    return true;
            }
            return false;
        });
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDelegate.getInstance().getNavigatorHolder().setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppDelegate.getInstance().getNavigatorHolder().removeNavigator();
    }
}
