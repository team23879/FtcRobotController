package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class RupeshOpMode2cp extends LinearOpMode {
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {
        frontleftDrive = hardwareMap.get(DcMotor.class, "front_left_motor");
        frontrightDrive = hardwareMap.get(DcMotor.class, "front_right_motor");

        frontleftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontrightDrive.setDirection(DcMotor.Direction.REVERSE); // Reverse right motor

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            double leftPower;
            double rightPower;

            double leftStick = -gamepad1.left_stick_y; // Reverse left joystick input
            double rightStick = -gamepad1.right_stick_y; // Reverse right joystick input

            leftPower = Range.clip(leftStick, -1.0, 1.0);
            rightPower = Range.clip(rightStick, -1.0, 1.0);

            telemetry.addData("Front Left Motor Power: ", frontleftDrive.getPower());
            telemetry.addData("Front Right Motor Power: ", frontrightDrive.getPower());

            frontleftDrive.setPower(leftPower);
            frontrightDrive.setPower(rightPower);

            telemetry.update();
        }
    }
}
