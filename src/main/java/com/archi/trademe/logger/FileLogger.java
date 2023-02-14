package com.archi.trademe.logger;

import com.archi.trademe.application.signals.NotificationListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements NotificationListener {

    private static FileLogger instance;
    private final String fileName = "logger.txt";

    private FileLogger() {
        try {
            var fileWriter = new FileWriter(this.fileName);
            var bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(" ------------------------ Start logging ------------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static FileLogger getInstance() {
        if (instance == null) {
            instance = new FileLogger();
        }
        return instance;
    }

    @Override
    public void onNotify(String message) {
        try {
            var fileWriter = new FileWriter(this.fileName, true);
            var bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(new Date() + " - ");
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
