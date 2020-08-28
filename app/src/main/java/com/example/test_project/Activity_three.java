package com.example.test_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Activity_three extends AppCompatActivity {

    ListView text;
    private final static String FILE_NAME = "questions.txt";

    private List<String> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //fillQuestionList();

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
    }

    String usText = new String();

    private String readFile() {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("questions.txt")));
            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                result.append(currentLine).append("\n");
            // LOG
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private List<String> stringParser() {
        String stringFromFile = readFile();
        String[] sortedText = stringFromFile.split("\\D");
        return new ArrayList<>(Arrays.asList(sortedText));
    }

    ListView listView = findViewById(R.id.fileText);
    /*public void openText(View view){

        FileInputStream fin = null;
        ListView listView = (ListView) findViewById(R.id.questionList);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            //listView.setAdapter(adapter);
        }
        catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fin!=null)
                    fin.close();
            }
            catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    /*private void fillQuestionList() {
        questionList.add("question 1");
        questionList.add("question 2");
        questionList.add("question 3");
        questionList.add("question 4");
        questionList.add("question 5");
    }*/
}
