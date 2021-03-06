/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */



@TeleOp(name="AutoModeDepot", group="Iterative Opmode")
//@Disabled
public class AutoModeDepot extends LinearOpMode {

    org.firstinspires.ftc.teamcode.HardwarePushbot robot           = new org.firstinspires.ftc.teamcode.HardwarePushbot();
    static final double     FORWARD_SPEED = 1;
    static final double     TURN_SPEED    = 0.5;
    private ElapsedTime     runtime = new ElapsedTime();
    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;

//        telemetry.addData("Status", "Ready to run");    //
//        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        while (true)
        {
            if (robot.limitSwitch.getState()){
                telemetry.addData("SWITCH", "CLOSED");
                sleep(1500);
                robot.lift.setPower(-1);
                break;

            }
            else{
                telemetry.addData("SWITCH", "OPEN");
                robot.lift.setPower(1);
            }

        }

//        //robot turns slightly to escape lift hook
//        robot.leftbackDrive.setPower(-0.8);
//        robot.leftfrontDrive.setPower(-0.8);
//        robot.rightbackDrive.setPower(0);
//        robot.rightfrontDrive.setPower(0);
////        sleep(250);
//        //robot moves forward slighty
//        robot.leftfrontDrive.setPower(0.8);
//        robot.leftbackDrive.setPower(0.8);
//        robot.rightfrontDrive.setPower(0.8);
//        robot.rightbackDrive.set-Power(0.8);
//        sleep(200);
        robot.rightfrontDrive.setPower(0.8);
        robot.rightbackDrive.setPower(0.8);
        robot.leftfrontDrive.setPower(-0.8);
        robot.leftbackDrive.setPower(-0.8);
        sleep(500);
        //robot turn 180 dregrees
        robot.rightbackDrive.setPower(1);
        robot.rightfrontDrive.setPower(1);
        robot.leftbackDrive.setPower(1);
        robot.leftbackDrive.setPower(1);
        sleep(1000);
//        //robot turns left 45 degrees
//        robot.rightbackDrive.setPower(-0.8);
//        robot.rightfrontDrive.setPower(-0.8);
//        robot.leftbackDrive.setPower(0);
//        robot.leftbackDrive.setPower(0);
//        sleep(625);
//        //Robot goes forward
        robot.rightfrontDrive.setPower(-0.8);
        robot.rightbackDrive.setPower(-0.8);
        robot.leftfrontDrive.setPower(0.8);
        robot.leftbackDrive.setPower(0.8);
        sleep(1000);

//        //robot turns right 90 degrees
//        robot.rightbackDrive.setPower(0);
//        robot.rightfrontDrive.setPower(0);
//        robot.leftbackDrive.setPower(0.8);
//        robot.leftbackDrive.setPower(0.8);
//        sleep(1250);
//        //robot moves forward slightly
//        robot.rightfrontDrive.setPower(0.8);
//        robot.rightbackDrive.setPower(0.8);
//        robot.leftfrontDrive.setPower(-0.8);
//        robot.leftbackDrive.setPower(-0.8);
//        sleep(750);
//        //robot drops marker
        robot.topArm.setPower(1);
        sleep(500);




    }
}
