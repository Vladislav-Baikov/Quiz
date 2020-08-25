package com.example.test_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_three extends AppCompatActivity {

    private List<String> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        fillQuestionList();
    }

    private void fillQuestionList() {
        questionList.add("question 1");
        questionList.add("question 2");
        questionList.add("question 3");
    }
}
