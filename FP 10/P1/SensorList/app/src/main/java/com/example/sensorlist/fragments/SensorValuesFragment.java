package com.example.sensorlist.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sensorlist.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


public class SensorValuesFragment extends Fragment {

    private Sensor mSensorLight;
    private TextView mTextSensorLight;
    private SensorManager mSensorManager;
    protected LineChart chart;
    protected int counter = 0;
    private List<Entry> entries = new ArrayList<Entry>();

    private SensorEventListener sensorEvents = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            int sensorType = event.sensor.getType();
            float currentValue = event.values[0];

            switch (sensorType) {
                // Event came from the light sensor.
                case Sensor.TYPE_LIGHT:
                    mTextSensorLight.setText(getResources().getString(
                            R.string.label_light, currentValue));
                    entries.add(new Entry(counter, currentValue ));
                    counter++;
                    LineDataSet dataSet = new LineDataSet(entries, "");
                    LineData lineData = new LineData(dataSet);
                    chart.setData(lineData);
                    chart.invalidate();

                    break;
                default:
                    // do nothing
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public SensorValuesFragment() {
        // Required empty public constructor
    }

    public static SensorValuesFragment newInstance(String param1, String param2) {
        SensorValuesFragment fragment = new SensorValuesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (mSensorLight != null) {
            mSensorManager.registerListener(sensorEvents, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(sensorEvents);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensor_values, container, false);
        mTextSensorLight = v.findViewById(R.id.sensorLight);

        chart = v.findViewById(R.id.chart);

        String sensor_error = getResources().getString(R.string.error_no_sensor);

        if (mSensorLight == null) {
            mTextSensorLight.setText(sensor_error);
        }

        return v;
    }
}