package com.taha.hamrahavaltest.controller;

import com.taha.hamrahavaltest.Service.XmlToObjectParserService;
import com.taha.hamrahavaltest.entity.MOTreeEntity;
import com.taha.hamrahavaltest.model.MOTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class XmlParsingController {
    private final Timer timer = new Timer();

    @Autowired
    private XmlToObjectParserService xmlToObjectParserService;

    @GetMapping("/parse-xml")
    public MOTree parseXmlFile(@RequestParam("filePath") String filePath) {
        try {
            File xmlFile = new File(filePath);
             var a = xmlToObjectParserService.parseXML(xmlFile);
             System.out.println("a: "+ a);
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/start-timer")
    public String startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Call the service method every 10 seconds
                MOTree result = null;
                try {
                    result = xmlToObjectParserService.parseXML(new File("/Users/tahamohammadi/Desktop/export2.xml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Service method called. Result: " + result);
            }
        }, 0, 10000);

        return "Timer started to call the service method every 10 seconds.";
    }

    @GetMapping("/start-timer-db")
    public String startTimerDb() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MOTree result = null;
                try {
                    result = xmlToObjectParserService.parseXML(new File("/Users/tahamohammadi/Desktop/export2.xml"));
                    MOTreeEntity moTreeEntity = xmlToObjectParserService.mapToEntity(result);
                    MOTreeEntity moTree = xmlToObjectParserService.saveToDb(moTreeEntity);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Service method called. Result: " + result);
            }
        }, 0, 10000); // Initial delay: 0ms, Repeat every 10 seconds (10000ms)

        return "Timer started to call the service method every 10 seconds.";
    }
}
