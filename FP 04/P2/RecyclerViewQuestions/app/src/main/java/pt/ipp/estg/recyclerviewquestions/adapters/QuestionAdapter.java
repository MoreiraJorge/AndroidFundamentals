package pt.ipp.estg.recyclerviewquestions.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.estg.recyclerviewquestions.QuestionActivity;
import pt.ipp.estg.recyclerviewquestions.R;
import pt.ipp.estg.recyclerviewquestions.models.Question;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context mContext;
    private List<Question> mQuestions;

    public QuestionAdapter(Context mContext, List<Question> mQuestions) {
        this.mContext = mContext;
        this.mQuestions = mQuestions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_question, parent, false);

        return new QuestionViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = mQuestions.get(position);

        TextView textView = holder.titleTextView;
        textView.setText(question.getTitle());

        Button button = holder.playButton;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, QuestionActivity.class);
                i.putExtra("QUESTION", question);
                mContext.startActivity(i);
            }
        });

        /*
        ImageView image = holder.questionStatus;
        if (question.getStatus().equals("Correto")) {
            image.setImageResource(R.drawable.green);
        } else if  (question.getStatus().equals("Errado")){
            image.setImageResource(R.drawable.red);
        } else {
            image.setImageResource(R.drawable.yellow);
        }
        */

        Log.d("QUESTION_ADAPTER", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public void updateData(List<Question> viewModels) {
        mQuestions.clear();
        mQuestions.addAll(viewModels);
        notifyDataSetChanged();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public Button playButton;
        public ImageView questionStatus;

        public QuestionViewHolder(View itemView) {
            super(itemView);

            questionStatus = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.textView);
            playButton = itemView.findViewById(R.id.button);
        }
    }
}
