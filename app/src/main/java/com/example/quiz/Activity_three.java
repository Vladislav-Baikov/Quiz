package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Activity_three extends AppCompatActivity {

    public static List<String> questionList = new ArrayList<>();
    public static List<String> fileContentList = Activity_two.fileContentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        readQuestions();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);
        ListView listView = findViewById(R.id.questionList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Activity_four.class);
                if (id == 0) {
                    int topicId = 0;
                }
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.questionText);
        textView.setText(readQuestions().toString());
    }

    private List<String> readQuestions() {
        String str;
        boolean breaker = false;
        for (int i = 0; i < fileContentList.size(); i++) {
            str = fileContentList.get(i);
            if (fileContentList.get(i).contains("<Тема>") && fileContentList.get(i+1).contains("/Тема") && !breaker) {
                i += 2;
                /*str = fileContentList.get(i) + " " + fileContentList.get(i+1);
                questionList.add(str);*/
                breaker = true;
                /*if (!str.contains("/Тема")) {
                    breaker = true;
                    str = fileContentList.get(i+1);
                    questionList.add(str);
                    i+=1;
                }*/
            }
            if (fileContentList.get(i).contains("<Тема>") && breaker && i > 2) {
                break;
            }
            if (fileContentList.get(i).contains(".")) {
                questionList.add(str);
            }
        }
        return questionList;
    }
}