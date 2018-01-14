package com.samer.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.samer.herome.Fragments.CharacterBioFragment;
import com.samer.herome.Fragments.MainFragment;
import com.samer.herome.Fragments.PickPowerFragment;
import com.samer.herome.R;


public class MainActivity extends AppCompatActivity
        implements MainFragment.MainFragmentInteractionListener,
        PickPowerFragment.PickPowerFragmentInteractionListener{


    FragmentManager manager;
    Fragment fragment;


    public static final String ID ="ID";

    public int screenWidth = 200, screenHeight = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;
        screenHeight = displaymetrics.heightPixels;

        loadMainScreen();
    }

    public  void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, pickPowerFragment)
                .addToBackStack(null)
                .commit();
    }


    public void loadCharacterBioScreen(int buttonID) {

        Bundle bundle = new Bundle();
        bundle.putInt(MainActivity.ID, buttonID);

        CharacterBioFragment characterBioFragment = new CharacterBioFragment();
        characterBioFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, characterBioFragment)
                .addToBackStack(null)
                .commit();
    }


    public void loadMainScreen() {
        manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    public void returnToMain() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance("main", "fragment"))
                .addToBackStack(null)
                .commit();
    }





    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }



    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }
}
