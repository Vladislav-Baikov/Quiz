package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_three extends AppCompatActivity {

    private final static String FILE_NAME = "questions.txt";

    private List<String> questionList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        readQuestions();
        fillQuestionList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);
        ListView listView = findViewById(R.id.questionList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), Activity_four.class);
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.questionText);
        textView.setText(readQuestions().toString());
    }

    private List<String> readQuestions() {
        List<String> abc = Activity_two.instOf().getFileContent();
        return abc;
    }

    private void fillQuestionList() {
        questionList.add("question 1");
        questionList.add("question 2");
        questionList.add("question 3");
        questionList.add("question 4");
        questionList.add("question 5");
    }
}
