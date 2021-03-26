package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_two extends AppCompatActivity {

    public File_reader fileReader = new File_reader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        fileReader.readFile();
        fileReader.getTopics();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fileReader.getTopicList());
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
        textView.setText(String.valueOf(fileReader.getFileContentList().size()));
    }
}