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

public class Activity_two extends AppCompatActivity {

    final String FILENAME = "topics.txt";
    final String FILENAMEQ = "questions.txt";
    final String LOG_TAG = "myLogs";
//    private List<String> topicList = new ArrayList<>();
    private List<String> fileContent = new ArrayList<>();
    private List<String> topicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

//        fillTopicList();
        readFile();
        readTopics();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, topicList);
        ListView listView = findViewById(R.id.topicList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), Activity_three.class);
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.topicListRd);
        textView.setText(topicList.toString());
    }

    private void readFile() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
            String str = "";
            while ((str = br.readLine()) != null) {
                this.fileContent.add(str);
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readTopics() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAMEQ), "windows-1251"));
            String str = "";
            while ((str = br.readLine()) != null) {
                if (str.contains("<Тема>")) {
                    String strCut;
                    strCut = str.replace("<Тема>", "");
                    strCut = strCut.replace("</Тема>", "");
                    this.topicList.add(strCut);
                    Log.d(LOG_TAG, strCut);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*private void fillTopicList() {
        this.topicList.add("First topic");
        this.topicList.add("Second topic");
        this.topicList.add("Third topic");
    }*/
}