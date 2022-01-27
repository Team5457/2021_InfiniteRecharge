/*package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Pickup extends Subsystem {

    // The 7 is the port on the RIO
    //private final PWMTalonSRX pickup = new PWMTalonSRX(2);
    public final static PWMVictorSPX pickup = new PWMVictorSPX(5);
    private PWMVictorSPX pickupMove = new PWMVictorSPX(7);
    @Override
    protected void initDefaultCommand() {
        
    }

    public void spinMotor(Joystick controller) {
        boolean a = controller.getRawButton(1);
        if (a){
            spinMotor();
        }    
        else{
            stopMotor();
        }
    }
    public void movePickup(Joystick joystick)
    {
        if (joystick.getRawAxis(1)>0)
            moveMotorDown();
        else if (joystick.getRawAxis(1)<0)
            moveMotorUp();
        else
            stopMotor();

    }
    
    // Spin the pickup motor at a set speed
    public void spinMotor() {
        pickup.setSpeed(-.5f);
        //System.out.println("Hi");
    }

    public void moveMotorDown()
    {
        pickupMove.setSpeed(-.5f);
    }

    public void moveMotorUp()
    {
        pickupMove.setSpeed(.5f);
    }

    public void stopMotor() {
        pickup.stopMotor();
    }
}
*/