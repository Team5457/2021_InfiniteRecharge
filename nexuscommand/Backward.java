package frc.robot.nexuscommand;
import frc.robot.Driver;
import frc.robot.Robot;
//use for autonomous
public class Backward extends drive
{
    private final double right;
    private final double left;
    private final Driver driveSystem;
    private final double angle;
    private final double time;
    private double r2;
    private double l2;
    private double error;
    
    //moves robot backward
    public Backward(double right,double left,double time, double angle, Driver driveSystem)   
    {
        super(right, left, time ,driveSystem);
        this.right = right;
        this.left = left;
        this.angle = angle;
        this.driveSystem= driveSystem;
        this.time = time;
        r2=right;
        l2=left;
    }
    public void whileExecuting()
    {
        if(this.getTime()==0)
            drive.startTime();
        if(this.getTime()>time)
        {

            this.isDone();
            drive.tReset();
        }
        driveSystem.driveMotorSpeeds(r2, l2);
        error = angle - Robot.currentAngle;
        if (Robot.angleIsGood)
        {
            if(error>1)
            {
            
                if(l2<=left)
                {
                    r2*=1.1;
                    l2/=1.1;
                }
            }
            if(error<-1)
            {
                if(r2<=right)
                {
                    l2*=1.1;
                    r2/=1.1;
                }

            }
        }
    }
}
