package com.example.yash.datastructure.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.yash.datastructure.Model.Question;
import com.example.yash.datastructure.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private ArrayList<Question> questions;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public QuestionAdapter(Context context, ArrayList<Question> questions) {
        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.question_item, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionViewHolder holder, final int position) {
        Question question_item = questions.get(position);
        holder.question_txt.setText(question_item.getQuestion());
        holder.answer_txt.setText(question_item.getAnswer());
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(String.valueOf(position + 1), Color.GRAY);
        holder.serial_no.setImageDrawable(drawable);

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        ImageView serial_no;
        TextView question_txt;
        TextView answer_txt;
        RelativeLayout buttonLayout;

        private QuestionViewHolder(View itemView) {
            super(itemView);
            serial_no = itemView.findViewById(R.id.serial_no);
            question_txt = itemView.findViewById(R.id.question_view);
            answer_txt = itemView.findViewById(R.id.answer_view);
            buttonLayout = itemView.findViewById(R.id.button_layout);
        }
    }

}
