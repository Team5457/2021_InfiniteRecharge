//just put in an angle to turn to and this will make the robot turn to it


package frc.robot.nexuscommand;

import frc.robot.Robot;
import frc.robot.Driver;

public class FixTurn extends MainCommand{

    
    public FixTurn(int t, Driver driveSystem)
    {
        Robot.auto.addCommand(new PidTurn(-0.5,0.5,t,driveSystem));
        Robot.auto.addCommand(new Wait(.25,driveSystem));
        Robot.auto.addCommand(new PidTurn(-0.5,0.5,t,driveSystem));
        Robot.auto.addCommand(new PidTurn(-0.5,0.5,t,driveSystem));
        Robot.auto.addCommand(new Wait(.25,driveSystem));
        

    }
    public void whileExecuting() {
        this.completed();
    }

 
    public void completed() {
        this.isDone();
    }


    

    
}
