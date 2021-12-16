package com.rahul;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

public class Automation {
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE= Executors.newScheduledThreadPool(1);
    public static void main(String[] args) throws InterruptedException {
        SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                takeScreenShot();
            }
        },1,1, TimeUnit.MINUTES);
    }

    public static void takeScreenShot(){
        try{
            Rectangle rectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image=new Robot().createScreenCapture(rectangle);
            ImageIO.write(image,"png",new File(System.currentTimeMillis()+".png"));
        }catch (AWTException e){
            System.out.println("Exception");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
