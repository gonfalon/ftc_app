package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;

/**
 * An empty op mode serving as a template for custom OpModes
 */
public class BenOp extends OpMode {

    DcMotor leftMotor, rightMotor;
    Servo claw;

    AutoController autoController;

    public double clawPosition;
    public double leftMotorPower;
    public double rightMotorPower;

    /*
    * Constructor
    */
    public BenOp() {

    }

    /*
    * Code to run when the op mode is first enabled goes here
    * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
    */
    @Override
    public void start() {

        leftMotor = hardwareMap.dcMotor.get("motor_1");
        rightMotor = hardwareMap.dcMotor.get("motor_2");

        claw = hardwareMap.servo.get("servo_5");

        autoController = new AutoController(this);

        leftMotorPower = 0;
        rightMotorPower = 0;
        clawPosition = 0;

    }


    /*
    * This method will be called repeatedly in a loop
    * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
    */
    @Override
    public void loop() {

        if(!autoController.finished)
        {
            autoController.run();
        }

        leftMotor.setPower(leftMotorPower);
        rightMotor.setPower(rightMotorPower);
        claw.setPosition(clawPosition);
    }

    /*
    * Code to run when the op mode is first disabled goes here
    * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
    */
    @Override
    public void stop() {

    }
}
