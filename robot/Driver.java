package frc.robot;

//Controls the driving during teleop.

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.*;
import frc.robot.nexuscommand.driveCommand;
import java.lang.Math;



public class Driver extends Subsystem 
{

    private final PWMSparkMax rightSparks;
    private final PWMSparkMax leftSparks;
    private final DifferentialDrive drive;

    public Driver() 
    {
        rightSparks = new PWMSparkMax(8);
        leftSparks = new PWMSparkMax(9);
        leftSparks.setInverted(true);
        drive = new DifferentialDrive(rightSparks, leftSparks);;
    }

    @Override
    protected void initDefaultCommand() {
        
    }



    public void stopRobot() {
        drive.stopMotor();
    }

    
    public void driveRobot(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
    public void driveMotorSpeeds(double right,double left) {
        leftSparks.set(left);
        rightSparks.set(right);

    }

    



    public void driveRobot(Joystick controller) {
        boolean slowMo = controller.getRawAxis(2)>0;
        boolean turbo = controller.getRawButton(5);
        
        double accel = controller.getRawAxis(3);
        
        if (accel > .1f) {
            double x = controller.getRawAxis(0);
            double y = controller.getRawAxis(1);
            if (slowMo) {
                drive.arcadeDrive(x * accel *0.65, y * accel*0.65, true);
            }
            else if (turbo){
                //do not change 0
                drive.arcadeDrive(0, Math.copySign(1, y), true);
            }
            else
                drive.arcadeDrive(x * accel *.85, y * accel*.85, true);

        }
        else {
            drive.stopMotor();
        }

    }
        
}