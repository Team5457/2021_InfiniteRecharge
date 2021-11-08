package frc.robot.nexuscommand;


import frc.robot.Driver;

//any comand that drives or uses the drive command is under this, similar to MainComand


//YEah never call this command because it doesnt stop just use the other stuff like bad and good and pidturn or whatever
public class driveCommand extends MainCommand
{
    private final Driver driveSystem;
    private final double left;
    private final double right;


    
    
    public driveCommand(double right, double left,Driver driveSystem) {
        super();
        this.driveSystem= driveSystem;
        this.right = right;
        this.left= left;
    }

    @Override
    public void whileExecuting() {
        driveSystem.driveMotorSpeeds(left,right);
    }

    @Override
    public void completed() {
        
    }



}
