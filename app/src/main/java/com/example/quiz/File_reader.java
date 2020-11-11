package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class File_reader extends AppCompatActivity {

    private String FILENAME = "questions.txt";
    private String LOG_TAG = "myLogs";
    private List<String> fileContentList = new ArrayList<>();
    private List<String> topicList = new ArrayList<>();
    private List<String> topicListQ = new ArrayList<>();

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

    public List<String> getTopics() {
        String str;
        // цикл для записи тем в коллекцию
        for (int i = 0; i < this.fileContentList.size(); i++) {
            str = this.fileContentList.get(i);
            if (str.contains("<Тема>")) {
                if (this.fileContentList.get(i+1).contains("/Тема")) {
                    str = this.fileContentList.get(i) + "\n" + this.fileContentList.get(i+1);
                }
                str = str.replace("<Тема>", "");
                str = str.replace("</Тема>", "");
                this.topicList.add(str);
                Log.d(LOG_TAG, str);
            }
            return this.topicList;
        }
        // хз, что за цикл, но вроде для списка вопросов нужен
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
        return this.topicListQ;
    }

    public List<String> getFileContentList() {
        return fileContentList;
    }

    public List<String> getTopicList() {
        return topicList;
    }

    public List<String> getTopicListQ() {
        return topicListQ;
    }
}
