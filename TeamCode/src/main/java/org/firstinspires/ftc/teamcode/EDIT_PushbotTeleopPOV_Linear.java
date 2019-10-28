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

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="EDIT_Pushbot: Teleop POV", group="Pushbot")
//@Disabled
public class EDIT_PushbotTeleopPOV_Linear extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
//    double          clawOffset      = 0;                       // Servo mid position
//    final double    CLAW_SPEED      = 0.02 ;                   // sets rate to move servo

    @Override
    public void runOpMode() {
        double left;
        double right;
        double drive;
        double turn;
        double max;
        double topPower;
        double NtopPower;
        double armup;
        double armdown;
        double leftfrontPower;
        double leftbackPower;
        double rightbackPower;
        double rightfrontPower;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            // This way it's also easy to just drive straight, or just turn.


            if (gamepad1.right_stick_x > 0) {
                robot.leftfrontDrive.setPower(gamepad1.right_stick_x);
                robot.rightfrontDrive.setPower(0);
                robot.rightbackDrive.setPower(0);
                robot.leftbackDrive.setPower(gamepad1.right_stick_x);
            } else if (gamepad1.right_stick_x < 0) {
                robot.leftfrontDrive.setPower(0);
                robot.rightfrontDrive.setPower(gamepad1.right_stick_x);
                robot.rightbackDrive.setPower(gamepad1.right_stick_x);
                robot.leftbackDrive.setPower(0);
            } else {
                robot.leftfrontDrive.setPower(-gamepad1.left_stick_y);
                robot.rightfrontDrive.setPower(gamepad1.left_stick_y);
                robot.rightbackDrive.setPower(gamepad1.left_stick_y);
                robot.leftbackDrive.setPower(-gamepad1.left_stick_y);
            }

//

            if (gamepad1.right_trigger > 0) {
                robot.topArm.setPower(gamepad1.right_trigger / 2);
            } else if (gamepad1.left_trigger > 0) {
                robot.topArm.setPower(-gamepad1.left_trigger / 2);
            } else
                robot.topArm.setPower(-0.1);


            // Use gamepad buttons to move arm up (Y) and down (A)
            if (gamepad1.right_bumper)
                robot.bottomArm.setPower(robot.ARM_UP_POWER);
            else if (gamepad1.left_bumper)
                robot.bottomArm.setPower(robot.ARM_DOWN_POWER);
            else
                robot.bottomArm.setPower(0);

            if (gamepad1.a)
                robot.lift.setPower(robot.LIFT_UP_POWER);
            else if (gamepad1.b)
                robot.lift.setPower(robot.LIFT_DOWN_POWER);
            else robot.lift.setPower(0);
//            while (true)
//            {if (robot.limitSwitch.getState())
//                robot.lift.setPower(0);}
//










            // Ramp the motors, according to the rampUp variable.
            if (robot.rampUp) {
                // Keep stepping up until we hit the max value.
                robot.power += robot.INCREMENT ;
                if (robot.power >= robot.MAX_FWD ) {
                    robot.power = robot.MAX_FWD;
                    robot.rampUp = !robot.rampUp;   // Switch ramp direction
                }
            }
            else {
                // Keep stepping down until we hit the min value.
                robot.power -= robot.INCREMENT ;
                if (robot.power <= robot.MAX_REV ) {
                    robot.power = robot.MAX_REV;
                    robot.rampUp = !robot.rampUp;  // Switch ramp direction
                }
            }


            if (gamepad1.dpad_up) {
                sleep(1000);
                if (gamepad1.dpad_up){
                =robot.rampUp; {
                    robot.bottomArm.setPower(gamepad1.dpad_up);
                }
            }


            // Send telemetry message to signify robot running;
//            telemetry.addData("claw",  "Offset = %.2f", clawOffset);


            // Pace this loop so jaw action is reasonable speed.
            sleep(50);
        }
    }

    static final String[] poem = new String[]{


    };
}
