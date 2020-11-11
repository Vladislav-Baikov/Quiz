package com.example.quiz;

import android.annotation.SuppressLint;
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

    public static List<String> questionList = new ArrayList<>();
    //public static List<String> fileContentList = Activity_two.fileContentList;
    public static long topicId;
    public static int topicInd;
    public static String topic;
    //public static List<String> topicListQ = Activity_two.topicListQ;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        topicId = getIntent().getLongExtra("topicId", -1);

        //readQuestions();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);
        ListView listView = findViewById(R.id.questionList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Activity_four.class);
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.questionText);
        //textView.setText(String.valueOf(topicId) + " " + (topic) + " " + (topicInd) + " " + (topicListQ.toString()));
    }

    /*private List<String> readQuestions() {
        boolean breaker = false;
        topic = topicListQ.get((int) topicId);
        topicInd = fileContentList.indexOf(topic);
        for (int i = topicInd; i < fileContentList.size(); i++) {
            if (fileContentList.get(i).contains("<Тема>") && breaker) {
                break;
            }
            if (fileContentList.get(i).contains("<Тема>") && !breaker) {
                if (fileContentList.get(i+1).contains("/Тема")) {
                    i += 2;
                }
                breaker = true;
            }
            questionList.add(fileContentList.get(i));
        }
        return questionList;
    }*/
}