package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.nio.channels.Pipe;

@TeleOp(name = "TeleOp", group = "")
public class Telop extends LinearOpMode {

    public void One_eighty(double leftmotors, double rightmotors){
        robot.rightfrontDrive.setPower(rightmotors);
        robot.rightbackDrive.setPower(rightmotors);
        robot.leftbackDrive.setPower(leftmotors);
        robot.leftfrontDrive.setPower(leftmotors);
        sleep(1000);
    }
    public void Three_Sixty(double motors){
        robot.rightfrontDrive.setPower(motors);
        robot.rightbackDrive.setPower(motors);
        robot.leftbackDrive.setPower(motors);
        robot.leftfrontDrive.setPower(motors);
        sleep(2000);
    }
    public void Forward (double leftmotors, double rightmotors ){
        robot.rightfrontDrive.setPower(rightmotors);
        robot.rightbackDrive.setPower(rightmotors);
        robot.leftbackDrive.setPower(leftmotors);
        robot.leftfrontDrive.setPower(leftmotors);
    }

    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware


    @Override
    public void runOpMode() throws InterruptedException {


        robot.init(hardwareMap);

        waitForStart();
        while (!isStopRequested()) {

//            double Position = robot.leftArm.getCurrentPosition();
            double Forward = -gamepad1.left_stick_y;
            double turning = gamepad1.right_stick_x;

            boolean LimitSwitch = robot.limitSwitch.getState();


//            telemetry.addData("Position:", Position);
            telemetry.addData("Y-axis:", Forward );
            telemetry.addData("X-axis:", turning );
            telemetry.addData("limitswich",LimitSwitch );
            telemetry.update();




//            if (gamepad1.dpad_up&&LimitSwitch&gamepad1.left_bumper) {
//
//
//
//                robot.leftArm.setPower(.2);
//                robot.rightArm.setPower(-.2);
//                sleep(1500);
//

            if (gamepad1.dpad_up&&gamepad1.left_bumper) {
                robot.leftArm.setPower(.3);
                robot.rightArm.setPower(-.3);
            }
            else if (!LimitSwitch&&!gamepad1.dpad_up) {
                robot.leftArm.setPower(0);
                robot.rightArm.setPower(0);
            }
            if (gamepad1.dpad_down && !LimitSwitch &&gamepad1.left_bumper){
                robot.leftArm.setPower(-.2);
                robot.rightArm.setPower(.2);

            }


            else if (LimitSwitch){
                robot.leftArm.setPower(0);
                robot.rightArm.setPower(0);
            }

            if (gamepad1.left_stick_button){
                One_eighty(1,-1);
            }
            else if (gamepad1.left_stick_button&&gamepad1.right_stick_button){
                Three_Sixty(1);
            }










                if (gamepad1.right_bumper) {
                    robot.clawn.setPosition(.5);
                } else {
                    robot.clawn.setPosition(0);
                }

                robot.rightfrontDrive.setPower(-Forward+turning);
                robot.rightbackDrive.setPower(-Forward+turning);
                robot.leftfrontDrive.setPower(Forward+turning);
                robot.leftbackDrive.setPower(Forward+turning);



            }

        }

    }

