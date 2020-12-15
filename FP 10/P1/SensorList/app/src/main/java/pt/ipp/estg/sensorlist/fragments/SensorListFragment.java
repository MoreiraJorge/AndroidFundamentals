package pt.ipp.estg.sensorlist.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pt.ipp.estg.sensorlist.R;

public class SensorListFragment extends Fragment {

    private TextView sensors;
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

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mSensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String sensList = "";

        for (Sensor sensor: mSensorList) {
            sensList +=  sensor.getName() + "\n";
        }

        sensors.setText(sensList);

        return v;
    }
}