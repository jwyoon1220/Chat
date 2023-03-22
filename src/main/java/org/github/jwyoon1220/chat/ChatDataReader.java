package org.github.jwyoon1220.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatDataReader {

    public List<String> readChatData(String fileName) {
        List<String> chatData = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                chatData.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chatData;
    }

}