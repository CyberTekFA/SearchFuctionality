package com.events.utilities;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.*;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
public class BrowserUtils {

    public static String getScreenShot(String name){

        String time = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir")+"//test-output//Screenshot"+name+time+".png";

        File fileDestination = new File(target);

        try {
            FileUtils.copyFile(source,fileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

}

