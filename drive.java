package frc.robot.nexuscommand;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.*;

//only use for autonomous
public class drive extends driveCommand
{
    private final double right;
    private final double left;
    private final Driver driveSystem;
    //private double angle;
    private final double time;
    private double r2;
    private double l2;
    //private double error;
    private final static Timer timer= new Timer();
    //updated to work properly
    //not tested so it probably doesn't work properly

    public drive(double right,double left,double time,Driver driveSystem)
    {
        super(right,left,driveSystem);
        this.driveSystem= driveSystem;
        this.right = right;
        this.left = left;
        this.time = time;
        r2=right;
        l2=left;  
    }

    //use this instead of the top one for driving
    /*public drive(double right,double left,double time, Driver driveSystem)
    {
        super(right,left,driveSystem);
        this.driveSystem= driveSystem;
        this.right = right;
        this.left = left;
        this.time = time;
        //this.angle = angle;
        r2=right;
        l2=left;
        
        
        
    }
    */public void whileExecuting()
    {
        if(this.getTime()==0)
            drive.startTime();
        driveSystem.driveMotorSpeeds(right,left);
        if(this.getTime()>time)
        {
            this.isDone();
            drive.tReset();
        }
        //driveSystem.driveMotorSpeeds(r2, l2);
        /*error = angle - Robot.currentAngle;
        if (Robot.angleIsGood)
        {
            if(error>1)
            {
            
                if(l2<=left)
                {
                    r2/=1.1;
                    l2*=1.1;
                }
            }
            if(error<-1)
            {
                if(r2<=right)
                {
                    l2/=1.1;
                    r2*=1.1;
                }

            }
        }
       */     
    }
    public static void tReset()
    {
        timer.stop();
        timer.reset();
    }
    public double getTime()
    {
        return timer.get();
    }
    public static void startTime()
    {
        timer.start();
    }
}
