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

    private File_reader fileReader = new File_reader();
    public static List<String> questionList = new ArrayList<>();
    public static long topicId;
    //public static long topicInd;
    public static String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        topicId = getIntent().getLongExtra("topicId", -1);

        fileReader.readFile();
        fileReader.getQuestions();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fileReader.getQuestionList());
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
        textView.setText(String.valueOf(fileReader.getFileContentList().size()));
    }
}