package com.example.quiz;

import android.content.Intent;
import android.os.AsyncTask;
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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Activity_two extends AppCompatActivity {

    private final File_reader fileReader = new File_reader();
    private final String FILENAME = "questions.txt";
    private final String LOG_TAG = "myLogs";
    private List<String> topicList = new ArrayList<>();
    private List<String> topicListQ = new ArrayList<>();
    private List<String> fileContentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //readFile();
        fileReader.readFile();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fileReader.getFileContentList());
        ListView listView = findViewById(R.id.topicList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), Activity_three.class);
                intent.putExtra("topicId", id);
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.topicListRd);
        textView.setText(String.valueOf(fileContentList.size() + " " + this.fileContentList.size()));
    }


    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME), "windows-1251"));
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.equals("")) {
                    this.fileContentList.add(str);
                    Log.d(LOG_TAG, str);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getTopics() {
        String str;
        for (int i = 0; i < fileContentList.size(); i++) {
            str = fileContentList.get(i);
                if (str.contains("<Тема>")) {
                    if (fileContentList.get(i+1).contains("/Тема")) {
                        str = fileContentList.get(i) + "\n" + fileContentList.get(i+1);
                    }
                    str = str.replace("<Тема>", "");
                    str = str.replace("</Тема>", "");
                    topicList.add(str);
                    Log.d(LOG_TAG, str);
                }
            }
        for (int i = 0; i < fileContentList.size(); i++) {
            str = fileContentList.get(i);
                if (str.contains("<Тема>") && fileContentList.get(i+1).contains("/Тема")) {
                    str = fileContentList.get(i);
                    topicListQ.add(str);
                    i += 2;
                }
                if (str.contains("<Тема>") && str.contains("</Тема>")) {
                    str = fileContentList.get(i);
                    topicListQ.add(str);
                }
        }
        return topicList;
    }
}