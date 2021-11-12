//turns the robot to an angle. But POORLY! NEVER USE THIS SHIT. just call fixturn
//but it isused for something so this cant be deleted

package frc.robot.nexuscommand;

import frc.robot.*;



public class PidTurn extends driveCommand
{
    private final Driver driveSystem;
    private double angle;
    private double left;
    private double right;
    
    double z = 0.0;
    
    
    //Robot.pidgey.getGeneralStatus(Robot.stat2);


    public PidTurn(double right, double left, double angle, Driver driveSystem)
    {
        super(right, left, driveSystem);
        this.angle = angle;
        this.driveSystem = driveSystem;
    }
    @Override
    public void whileExecuting()
    {
        //System.out.println(Robot.currentAngle);
        driveSystem.driveMotorSpeeds(right,left);
        
        if(Robot.angleIsGood)
        {
            double error = angle - Robot.currentAngle;
            if (error > 10)
            {
                right = -0.5;
                left = 0.5;
            }
            else if (error > 1)
            {
                right = -0.37;
                left = 0.37;
            }
            else if (error < -10)
            {
                right = 0.5;
                left = -0.5;
            }
            else if (error < -1)
            {
                right = 0.42;
                left = -0.42;
                
            }
            else
            {

                //Robot.pidgey.setFusedHeading(0.0, Robot.kTimeoutMs);
            
                if(-1 < error && error < 1)
                {

                    this.isDone();
                }
                

            }

        }

    }

}
