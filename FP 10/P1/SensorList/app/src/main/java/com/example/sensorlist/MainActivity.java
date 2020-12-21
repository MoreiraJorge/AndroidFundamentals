package com.example.sensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import com.example.sensorlist.fragments.SensorListFragment;
import com.example.sensorlist.fragments.SensorValuesFragment;

public class MainActivity extends AppCompatActivity {

    private SensorListFragment slf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slf = new SensorListFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, slf).commit();
    }

    public void replaceFragment(){
            SensorValuesFragment newFragment = new SensorValuesFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newFragment)
                    .addToBackStack(null)
                    .commit();
    }
}