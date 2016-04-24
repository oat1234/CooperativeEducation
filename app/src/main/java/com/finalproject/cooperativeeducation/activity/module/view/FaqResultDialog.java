package com.finalproject.cooperativeeducation.activity.module.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.finalproject.cooperativeeducation.activity.R;

/**
 * Created by master on 24/4/2559.
 */
public class FaqResultDialog extends Dialog {

    private TextView txtQuestion;
    private TextView txtAnswer;
    private String question;
    private String anwser;

    public FaqResultDialog(Context context) {
        super(context);
        init();
    }

    public FaqResultDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected FaqResultDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init(){
        setContentView(R.layout.view_dialog_faq);
        txtQuestion = (TextView) findViewById(R.id.txtQuestionDialog);
        txtAnswer = (TextView) findViewById(R.id.txtAnswerDialog);
    }

    public void displayData(){
        txtQuestion.setText(getQuestion());
        txtAnswer.setText(getAnwser());
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }
}
