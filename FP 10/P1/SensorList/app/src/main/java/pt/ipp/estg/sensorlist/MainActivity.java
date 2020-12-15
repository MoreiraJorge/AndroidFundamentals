package pt.ipp.estg.sensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import pt.ipp.estg.sensorlist.fragments.SensorListFragment;

public class MainActivity extends AppCompatActivity {

    private SensorListFragment slf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slf = new SensorListFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, slf).commit();

    }
}