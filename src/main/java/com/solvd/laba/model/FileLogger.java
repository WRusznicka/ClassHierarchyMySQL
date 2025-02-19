package com.solvd.laba.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class FileLogger implements Observer{

    @Override
    public void log(String message, Class cl) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/logs.txt", true))){
            writer.append("[INFO]" + LocalDateTime.now() + " " + cl + " - " + message + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
