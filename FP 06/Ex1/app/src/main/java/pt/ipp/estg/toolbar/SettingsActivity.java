package pt.ipp.estg.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Toolbar myToolBar;
    private RadioGroup colorRadios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        colorRadios = findViewById(R.id.colorRadios);
        colorRadios.setOnCheckedChangeListener(this);

        myToolBar = (Toolbar) findViewById(R.id.toolbar);
        myToolBar.setTitle("Definições");
        setSupportActionBar(myToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    //add to shared preferences (Key,value) -> (red,red)
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(checkedId == R.id.radioWhite){
        }
        if(checkedId == R.id.radioYellow){
        }
        if(checkedId == R.id.radioRed){
        }
    }
}