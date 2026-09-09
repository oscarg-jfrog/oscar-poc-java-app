package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        logger.info("Starting poc-java-app");
        try {
            String json = mapper.writeValueAsString(new Message("Hello from poc-java-app!"));
            logger.info("Output: {}", json);
            System.out.println(json);
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    static class Message {
        private String text;
        Message(String text) { this.text = text; }
        public String getText() { return text; }
    }
}
