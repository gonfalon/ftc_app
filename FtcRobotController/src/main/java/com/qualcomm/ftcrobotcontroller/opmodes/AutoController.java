package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by ben on 7/13/15.
 */
public class AutoController implements Runnable{

    BenOp main;
    public boolean finished;

    public AutoController(BenOp main)
    {
        this.main = main;
        finished = false;
    }

    public void wait1Msec(int length)
    {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
        }
    }

    public void run() {

        main.leftMotorPower = 1;
        main.rightMotorPower = 1;
        wait1Msec(2000);
        main.rightMotorPower = -1;
        wait1Msec(500);
        main.rightMotorPower = 0;
        main.leftMotorPower = 0;
        finished = true;
    }
}
