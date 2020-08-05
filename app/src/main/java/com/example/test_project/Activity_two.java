package com.example.test_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity_two extends AppCompatActivity {

    private List<String> topicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        fillTopicList();
        ListView listView = findViewById(R.id.topicList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, topicList);
        listView.setAdapter(adapter);
    }

    private void fillTopicList() {
        this.topicList.add("First topic");
        this.topicList.add("Second topic");
        this.topicList.add("Third topic");
    }
}