package frc.robot.nexuscommand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
public class autoShoot extends MainCommand{

    private Shoot shootsystem;
    private final static Timer timer= new Timer();
    private double time;

    public autoShoot(double time, Shoot shootsystem)
    {
        super();
        this.shootsystem= shootsystem;
        this.time = time; 
    }

    @Override
    public void whileExecuting() {
        shootsystem.shoot(1);
        timer.start();
        
        if(this.getTime()==0)
            drive.startTime();
            System.out.println("Timer on");
        shootsystem.shoot(1);
        if(this.getTime()>time)
        {
            this.isDone();
            drive.tReset();
        }

        
    }

    @Override
    public void completed() {
        shootsystem.stopShooting();
        this.tReset();
        
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
