package com.solvd.laba.model;

import org.apache.logging.log4j.LogManager;

public class Logger implements Observer{

    private static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    @Override
    public void log(String message, Class cl) {
        LOGGER = LogManager.getLogger(cl);
        LOGGER.info(message);
    }
}
