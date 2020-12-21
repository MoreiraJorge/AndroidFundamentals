package com.example.sensorlist.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensorlist.MainActivity;
import com.example.sensorlist.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SensorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SensorListFragment extends Fragment {

    private TextView sensors;
    private Button values;
    private SensorManager sensorManager;

    public SensorListFragment() {
        // Required empty public constructor
    }

    public static SensorListFragment newInstance(String param1, String param2) {
        SensorListFragment fragment = new SensorListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensor_list, container, false);

        sensors = v.findViewById(R.id.sensorList);
        values = v.findViewById(R.id.button);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mSensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String sensList = "";

        for (Sensor sensor: mSensorList) {
            sensList +=  sensor.getName() + "\n";
        }

        sensors.setText(sensList);

        values.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment();
            }
        });

        return v;
    }
}