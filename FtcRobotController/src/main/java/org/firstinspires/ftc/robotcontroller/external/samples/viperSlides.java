package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class viperSlides extends LinearOpMode {
    private LinearOpMode myOpMode = null;
    private DcMotor rightSlider = null;

    @Override
    public void runOpMode() throws InterruptedException {
        rightSlider = hardwareMap.get(DcMotor.class, "rightSliderMotor");
        waitForStart();
        telemetry.addData("Before Start", "1");
        while (true) {
            if (gamepad1.a) {
                rightSlider.setDirection(DcMotor.Direction.FORWARD);
                rightSlider.setPower(0.5);
                telemetry.addData("In While", "1");
            }
            if (gamepad1.b) {
                rightSlider.setDirection(DcMotor.Direction.REVERSE);
                rightSlider.setPower(0.5);
                telemetry.addData("In While", "1");
            }
        }
    }
}
