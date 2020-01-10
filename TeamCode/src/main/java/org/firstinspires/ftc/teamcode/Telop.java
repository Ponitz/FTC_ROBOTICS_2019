package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.nio.channels.Pipe;

@TeleOp(name = "TeleOp", group = "")
public class Telop extends LinearOpMode {

    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware


    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();
        while (!isStopRequested()) {

            double Position = robot.leftArm.getCurrentPosition();
            double Forward = gamepad1.left_stick_y;
            double turning = gamepad1.right_stick_x;
            boolean LimitSwitch = robot.limitSwitch.getState();

            telemetry.addData("Position:", Position);
            telemetry.addData("Y-axis:", Forward );
            telemetry.addData("X-axis:", turning );
            telemetry.addData("limitswich",LimitSwitch );
            telemetry.update();

//
//            if (gamepad1.dpad_up ) {
//                robot.leftArm.
//
//
////                   robot.leftArm.setPower(.5);
////                   robot.rightArm.setPower(-.5);
//                robot.leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                robot.rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                robot.leftArm.setTargetPosition(0);
//                robot.leftArm.setTargetPosition(0);
//
//
////            }else if (Position>3){
////               break;
//
//            }
//
//
//            if (gamepad1.dpad_down & robot.leftArm.getTargetPosition() < 1) {
//
//                robot.leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                robot.rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);




                robot.rightfrontDrive.setPower(Forward + turning);
                robot.leftfrontDrive.setPower(-Forward + turning);
                robot.rightbackDrive.setPower(Forward + turning);
                robot.leftbackDrive.setPower(-Forward + turning);

                if (gamepad1.right_bumper) {
                    robot.clawn.setPosition(.5);
                } else {
                    robot.clawn.setPosition(0);
                }


            }

        }

    }

