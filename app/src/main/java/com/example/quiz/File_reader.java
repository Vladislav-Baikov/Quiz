package com.example.quiz;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class File_reader {

    private String FILENAME = "/data/data/com.example.test_project/files/questions.txt";
    private String LOG_TAG = "myLogs";
    private List<String> fileContentList = new ArrayList<>();
    private List<String> topicList = new ArrayList<>();
    private List<String> topicListQ = new ArrayList<>();
    private List<String> questionList = new ArrayList<>();

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream(FILENAME), "windows-1251"));
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.equals("")) {
                    fileContentList.add(str);
                    Log.d(LOG_TAG, str);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTopics() {
        String str;
        // цикл для записи тем в коллекцию
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
    }

    /*public void getQuestions() {
        int topicId = 1 + (int) Activity_three.topicId;
        int topicCnt = 0;
        for (int i = 0; i < fileContentList.size(); i++) {
            if (fileContentList.get(i).contains("</Тема>")) {
                topicCnt++;
                if (topicCnt == topicId) {
                    i++;
                    while (!fileContentList.get(i).contains("<Тема>")) {
                        questionList.add(fileContentList.get(i));
                        i++;
                        if (fileContentList.get(i+1).contains("\n")) {
                            questionList.add(fileContentList.get(i+1));
                        }
                        i++;
                    }
                }
            }
        }
    }*/

    public void getQuestions() {
        int topicId = 1 + (int) Activity_three.topicId;
        int topicCnt = 0;
        for (int i = 0; i < fileContentList.size(); i++) {
            if (topicCnt == topicId) {
                while (!fileContentList.get(i).contains("<Тема>")) {
                    questionList.add(fileContentList.get(i));
                    if (fileContentList.get(i+1).matches("\n")) {
                        questionList.add(fileContentList.get(i+1));
                    }
                    i++;
                }
                break;
            }
            if (fileContentList.get(i).contains("</Тема>")) {
                topicCnt++;
            }
        }
    }



    public List<String> getFileContentList() {
        return fileContentList;
    }

    public List<String> getTopicList() {
        return topicList;
    }

    public List<String> getQuestionList() {
        return questionList;
    }
}
