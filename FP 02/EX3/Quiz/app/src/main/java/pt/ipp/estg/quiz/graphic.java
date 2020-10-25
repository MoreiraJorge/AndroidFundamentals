package pt.ipp.estg.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class graphic extends AppCompatActivity implements View.OnClickListener {

    private TextView correct;
    private TextView wrong;
    private Button mbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        correct = findViewById(R.id.textView3);
        wrong = findViewById(R.id.textView4);
        mbutton3 = findViewById(R.id.button3);

        correct.setText(getIntent().getStringExtra("CORRECT"));
        wrong.setText(getIntent().getStringExtra("WRONG"));

        mbutton3.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        finish();
    }
}