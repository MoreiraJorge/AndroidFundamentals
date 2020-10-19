package pt.ipp.estg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButtonToast;
    private Button mButtonNewView;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextTextPersonName3);
        mButtonToast = findViewById(R.id.button);
        mButtonNewView = findViewById(R.id.button2);

        Context context = this;
        intent = new Intent(this, NewActivity.class);

        mButtonToast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int duration = Toast.LENGTH_SHORT;
                String text = mEditText.getText().toString();
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
                toast.show();
                // Do something in response to button click
            }
        });

        mButtonNewView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2();
                // Do something in response to button click
            }
        });

        Log.d("NEW_ACTIVITY","onCreate()");
    }

    private void openActivity2(){
        intent.putExtra("KEY", mEditText.getText().toString());
        startActivity(intent);
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.d("MAIN_ACTIVITY","onStart()");
    }

}