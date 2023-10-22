package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class RupeshOpMode_Iterative extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleftDrive = null;
    private DcMotor backleftDrive = null;

    private DcMotor frontrightDrive = null;
    private DcMotor backrightDrive = null;



    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        frontleftDrive  = hardwareMap.get(DcMotor.class, "front_left_motor");
        backleftDrive  = hardwareMap.get(DcMotor.class, "back_left_motor");

        frontrightDrive  = hardwareMap.get(DcMotor.class, "front_right_motor");
        backrightDrive  = hardwareMap.get(DcMotor.class, "back_right_motor");


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
        backleftDrive.setDirection(DcMotor.Direction.REVERSE);

        frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        backrightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");


    }

    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double frontleftPower;
        double backleftPower;

        double frontrightPower;
        double backrightPower;

        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.

        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        double ldrive = -gamepad1.left_stick_y;
        double rdrive = -gamepad1.right_stick_y;

        frontleftPower    = Range.clip(ldrive, -1.0, 1.0) ;
        backleftPower   = Range.clip(ldrive, -1.0, 1.0) ;

        frontrightPower    = Range.clip(rdrive, -1.0, 1.0) ;
        backrightPower   = Range.clip(rdrive, -1.0, 1.0) ;

        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
        // leftPower  = -gamepad1.left_stick_y ;
        // rightPower = -gamepad1.right_stick_y ;

        // Send calculated power to wheels
        frontleftDrive.setPower(frontleftPower);
        backleftDrive.setPower(backleftPower);

        frontrightDrive.setPower(frontrightPower);
        backrightDrive.setPower(backrightPower);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }
}
