package pt.ipp.estg.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class graphic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("GRAPHIC","onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("GRAPHIC","onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("GRAPHIC","onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("GRAPHIC","onStop()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("GRAPHIC","onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("GRAPHIC","onDestroy()");
    }
}