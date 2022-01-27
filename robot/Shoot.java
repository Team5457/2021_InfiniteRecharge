/*package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Shoot extends Subsystem {
    private final Spark MotorLeft;
    private final Spark MotorRight;
    
    private final float kShootSpeed = .8f;

    @Override
    protected void initDefaultCommand() {

    }

    public Shoot() {
        MotorLeft = new Spark(0); //0 port on RIO
        MotorRight = new Spark(1); //1 port on RIO
        
       

        
        //shootLeft.setInverted(true);
    }

    public void shoot() {
        shoot(kShootSpeed);
    }

    public void shoot(double speed) {
        if (Math.abs(speed) > .05) {
            MotorLeft.setSpeed(-1 * speed);
            MotorRight.setSpeed(speed);
        }
        else {
            MotorLeft.stopMotor();
            MotorRight.stopMotor();
        
        }
    }


	public void shoot(Joystick controller) {
        boolean a = controller.getRawButton(1);
    

        if (a)
            shoot(1);
        else
            stopShooting();
    }

    public void stopShooting() {
        MotorRight.stopMotor();
        MotorLeft.stopMotor();
        
    }
}
*/