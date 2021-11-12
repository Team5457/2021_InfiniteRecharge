package frc.robot.nexuscommand;

import frc.robot.Driver;

public class Stop extends MainCommand{
    private final Driver driveSystem;
    public Stop(Driver driveSystem)
    {
        this.driveSystem=driveSystem;
    }
    public void whileExecuting(){
        this.isDone();
    }

    public void completed()
    {
        driveSystem.stopRobot();
    }
}
