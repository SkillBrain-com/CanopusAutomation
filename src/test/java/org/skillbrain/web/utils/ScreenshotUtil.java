package org.skillbrain.web.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {


    public void screenshot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir");

        String destination = location + "/logs/screenshots/screenshot-"
                + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm:ss").format(LocalDateTime.now()) +".png" ;
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException ex) {
            System.out.println("Something went wrong when taking screenshot");
            ex.printStackTrace();
        }
    }
}
