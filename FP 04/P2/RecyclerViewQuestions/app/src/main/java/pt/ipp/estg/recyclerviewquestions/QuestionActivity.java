package pt.ipp.estg.recyclerviewquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pt.ipp.estg.recyclerviewquestions.models.Question;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private EditText answerText;
    private Button submit;
    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        titleTextView = findViewById(R.id.textView4);
        descriptionTextView = findViewById(R.id.textView5);
        answerText = findViewById(R.id.editTextNumber);
        submit = findViewById(R.id.button2);

        question = (Question) getIntent().getSerializableExtra("QUESTION");

        titleTextView.setText(question.getTitle());
        descriptionTextView.setText(question.getDescription());

        submit.setOnClickListener(this);

        Log.d("QUESTION_ACTIVITY","onCreate()");
    }

    @Override
    public void onClick(View v) {
        if(Integer.valueOf((answerText.getText().toString())) ==
                Integer.parseInt(question.getAnswer())){
            question.setStatus("Correto");
        } else{
            question.setStatus("Errado");
        }

        System.out.println("Estado da resposta: " + question.getStatus());
        finish();
    }
}