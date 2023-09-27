package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class RupeshOpMode extends LinearOpMode {
    private DcMotor frontleftDrive   = null;
    private DcMotor frontrightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {
        frontleftDrive  = hardwareMap.get(DcMotor.class, "front_left_motor");
        frontrightDrive  = hardwareMap.get(DcMotor.class, "front_right_motor");

        frontleftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontrightDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()) {
            double frontleftPower;
            double frontrightPower;
            double turnPower;

            double drive = gamepad1.left_stick_y;
            double turn  = -gamepad1.right_stick_x;

            frontleftPower = Range.clip(drive - turn, -1.0, 1.0) ;
            frontrightPower = Range.clip(drive - turn, -1.0, 1.0) ;

            turnPower = Range.clip(drive + turn, -1.0, 1.0) ;

            telemetry.addData("Front Left Motor Power: ", frontleftDrive.getPower());
            telemetry.addData("Front Right Motor Power: ", frontrightDrive.getPower());

            frontleftDrive.setPower(frontleftPower);
            frontrightDrive.setPower(frontrightPower);

            //leftDrive.setDirection(DcMotor.Direction.REVERSE);
            //leftDrive.setPower(0.5); //1 is the highest power

            telemetry.update();
        }
    }
}
