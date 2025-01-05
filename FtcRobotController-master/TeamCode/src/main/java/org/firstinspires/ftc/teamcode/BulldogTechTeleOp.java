package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//import org.checkerframework.checker.units.qual.Speed;

@TeleOp(name = "BulldogTechTeleOp")
public class BulldogTechTeleOp extends LinearOpMode {

    private DcMotorEx FL, FR, BL, BR, LS, arm;
    //private Servo RE, LE, LW, RW;
    private CRServo claw;
    // private Servo LO, RO;

    private static boolean isGoing = false;
    private static boolean isUp = false;


    //private CRServo RI,    LI;

    public double pivot, vertical, horizontal;

    @Override
    public void runOpMode() throws InterruptedException {
        //servos
        claw = hardwareMap.get(CRServo.class, "claw");

        //CRservos
        /*
        LI = hardwareMap.get(CRServo.class, "LI");
        RI = hardwareMap.get(CRServo.class, "RI");
        */
        //motors
        FL = hardwareMap.get(DcMotorEx.class, "leftFront");
        FR = hardwareMap.get(DcMotorEx.class, "rightFront");
        BL = hardwareMap.get(DcMotorEx.class, "leftRear");
        BR = hardwareMap.get(DcMotorEx.class, "rightRear");
        LS = hardwareMap.get(DcMotorEx.class, "LS");
        arm = hardwareMap.get(DcMotorEx.class, "arm");


        // normal mode
        /*
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        */

        //reverse mode

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);

        LS.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(DcMotorSimple.Direction.FORWARD);

        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LS.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LS.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //System.out.println(claw.getPosition());

        waitForStart();

        if (opModeIsActive()) {
            /*System.out.print(claw.getPosition());
            System.out.print(claw.getPosition());
            telemetry.addLine(Double.toString(claw.getPosition()));
            */
            telemetry.update();

            //LW.setPosition(0+.095);
            //RW.setPosition(1-.095);
            while (opModeIsActive()) {

                vertical = Range.clip(-gamepad1.left_stick_y, -1, 1);
                horizontal = Range.clip(gamepad1.left_stick_x, -1, 1);
                pivot = Range.clip(gamepad1.right_stick_x, -1, 1);
                FR.setPower(pivot + (vertical - horizontal));
                BR.setPower(pivot + (vertical + horizontal));
                FL.setPower(-pivot + (vertical + horizontal));
                BL.setPower(-pivot + (vertical - horizontal));




                /*if (gamepad1.y) {

                    /**
                     FOR EACH LE .2, CHANGE RE BY .035.
                     for each LE 1/5, change re by 1/20.
                     for each le 1, change re by 1/4

                    isUp = true;
                    LS.setPower(0.1);
                    LS.setTargetPosition(2100);
                    LS.setMode(DcMotor.RunMode.RUN_TO_POSITION);


                    //sleep(2000);
                    //LE.setPosition(0.0);
                    //RE.setPosition((1 - 0.004));
                    //LE.setPosition(.62);
                    //RE.setPosition(.89955-.004);
                    //sleep(2000);

                    //sleep(2000);
                    //LW.setPosition(0+0.01);
                    //RW.setPosition(1-0.01);
                    //sleep(1000);
                    //LW.setPosition();
                    //RW.setPosition();
                    //RW.setPosition(.9);
                    //sleep(2000);

                    //LW.setPosition(.45);
//                    RW.setPosition(.55);
//                    LE.setPosition(0.0);
//                    RE.setPosition((1 - 0.004));

                }

                if (gamepad1.b) {
                    isUp = true;
                    LS.setPower(.5);
                    LS.setTargetPosition(800);
                    LS.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                }
                if (gamepad1.x) {
                    isUp = true;
                    LS.setPower(0.5);
                    LS.setTargetPosition(1200);
                    LS.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                }
                if (gamepad1.a) {
                    isUp = false;
                    LS.setPower(0.5);
                    LS.setTargetPosition(10);
                    LS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
                */
                if (gamepad1.b) {
                    arm.setPower(.4);

                }

                if (gamepad1.a) {
                    arm.setPower(-.4);

                }
                if (!gamepad1.b && !gamepad1.a) {
                    arm.setPower(0);
                }

                if (gamepad1.dpad_left) {
                    claw.setPower(.5);
                }
                if(gamepad1.dpad_right) {
                    claw.setPower(-.5);
                }
                if(!gamepad1.dpad_left && !gamepad1.dpad_right) {
                    claw.setPower(0);
                }

                if (gamepad1.dpad_up) {
                    LS.setPower(.75);
                }

                if (gamepad1.dpad_down) {
                    LS.setPower(-.75);
                }

                if (!gamepad1.dpad_down && !gamepad1.dpad_up) {
                    LS.setPower(0);
                }



                /*if (gamepad1.b) {
                    Intake.setPower(.86);
                }

                if (gamepad2.y && isUp) {
                    LE.setPosition(.62);
                    RE.setPosition(.89955-.004);


                }
                if (gamepad2.x) {

                    LE.setPosition(0);
                    RE.setPosition(1-.004);
                }
                if (gamepad2.a && isUp) {

                    LW.setPosition(.45);
                    RW.setPosition(.55);
                }

                if (gamepad2.b) {

                    LW.setPosition(0+0.1);
                    RW.setPosition(1-.1);
                }

                if (gamepad2.left_bumper) {
                    Gate.setPosition(.06);
                    telemetry.addLine("Closed");
                }
                if (gamepad2.right_bumper) {
                    Gate.setPosition(.3);
                    telemetry.addLine("Open");
                }
                if (gamepad1.dpad_up) {

                    //FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    Intake.setPower(-.82);
                    sleep(500);
                    isGoing = true;


                }
                if (gamepad1.dpad_down) {

                    //FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    Intake.setPower(0);
                    sleep(150);
                    isGoing = false;
                }
//                if (gamepad1.dpad_down) {
//
////                  FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                  FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                  BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                  BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//                    LI.setPower(1);
//                    RI.setPower(-1);
//                    sleep(150);
//                    isGoing = true;
//                }

                 */

//                if ((gamepad1.right_bumper || gamepad2.right_bumper) && !isUp) {
//                    //FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    FL.setPower(0);
//                    //FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    FR.setPower(0);
//                    //BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    BR.setPower(0);
//                    //BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    BL.setPower(0);
//                    //RO.setPosition(Math.min(-.2, RO.getPosition()-.05));
//
//                    //LO.setPosition(Math.max(0.5, LO.getPosition()+.05));
//                    isUp = true;
//                    LO.setPower(0.30);
//                    RO.setPower(-0.30);
//                    sleep(500);
//                    //LO.setPower(-0.25);
//                    //RO.setPower(0.25);
//                    //sleep(800);
//                    LO.setPower(0);
//                    RO.setPower(0);
//                    /*sleep(1000);
//                    LO.setPower(0);
//                    RO.setPower(0);
//                    //sleep(2000);
//
//                     */
//                    //LO.setPosition(-0.2);
//                    //RO.setPosition(0.5);
//                    vertical = Range.clip(-gamepad1.left_stick_y, -1, 1);
//                    horizontal = Range.clip(gamepad1.left_stick_x, -1, 1);
//                    //normal
//                    //pivot = (Range.clip(gamepad1.right_stick_x, -1, 1));
//                    //reverse
//                    pivot = (Range.clip(gamepad1.right_stick_x, -1, 1));
//
//                    FR.setPower(-pivot + (vertical - horizontal));
//                    BR.setPower(-pivot + (vertical + horizontal));
//                    FL.setPower(pivot + (vertical + horizontal));
//                    BL.setPower(pivot + (vertical - horizontal));
//                }
//                System.out.print(gamepad1.right_trigger);
//                if ((gamepad1.y || gamepad2.y) && isUp) {
////                    FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                    FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                    BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////                    BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    isUp = false;
//                    FR.setPower(0);
//                    FL.setPower(0);
//                    BL.setPower(0);
//                    BR.setPower(0);
//                    LO.setPower(-0.30);
//                    RO.setPower(0.30);
//                    sleep(500);
//                    //LO.setPower(-0.25);
//                    //RO.setPower(0.25);
//                    //sleep(800);
//                    LO.setPower(0);
//                    RO.setPower(0);
//                    vertical = Range.clip(-gamepad1.left_stick_y, -1, 1);
//                    horizontal = Range.clip(gamepad1.left_stick_x, -1, 1);
//                    pivot = Range.clip(gamepad1.right_stick_x, -1, 1);
//                    FR.setPower((-pivot + (vertical - horizontal)));
//                    BR.setPower((-pivot + (vertical + horizontal)));
//                    FL.setPower((pivot + (vertical + horizontal)));
//                    BL.setPower((pivot + (vertical - horizontal)));
//                    //LO.setPosition(-0.2);
//                    //RO.setPosition(0.5);
//                }
//                if (gamepad1.right_trigger != 0) {
//                    FR.setPower((-pivot + (vertical - horizontal)) / 2);
//                    BR.setPower((-pivot + (vertical + horizontal)) / 2);
//                    FL.setPower((pivot + (vertical + horizontal)) / 2);
//                    BL.setPower((pivot + (vertical - horizontal)) / 2);
//                }

//                if (gamepad1.right_trigger != 0) {
//                    FR.setPower((-pivot + (vertical - horizontal)) / 2);
//                    BR.setPower((-pivot + (vertical + horizontal)) / 2);
//                    FL.setPower((pivot + (vertical + horizontal)) / 2);
//                    BL.setPower((pivot + (vertical - horizontal)) / 2);
//                }
//                telemetry.addLine(String.format("The trigger", gamepad1.right_trigger));

            }
        }
    }
}


