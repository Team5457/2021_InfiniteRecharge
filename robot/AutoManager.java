package frc.robot;
import java.util.ArrayList;

// where all of the auto commands go through
import frc.robot.nexuscommand.*;
public class AutoManager {
    private final ArrayList<MainCommand> commands = new ArrayList<MainCommand>();

    private boolean isExecuting = false;
    public boolean driveExecuting = false;
    private int count=0;
   
    private MainCommand currentCommand;

    public void execute() {
        //if there are no more comands, don't do anything
        if (count-1>commands.size()) return;
        // if the command is null, go to the next command
        MainCommand com = commands.get(count);
        currentCommand = com;
        isExecuting = true;
        
        //if the current command in autonomous is not completed, runs the command.
        if (!currentCommand.isCompleted()) {
            currentCommand.whileExecuting();
            driveExecuting = currentCommand instanceof driveCommand;
        }
        // when the command is completed, sets the command to null(zero)
        //also resets the gyro sensor's values
        else {
            System.out.println("Completed");
            count++;
            isExecuting = false;
            Robot.ahrs.resetDisplacement();
            
        }
        
    }

    public boolean getIsExecuting(){
        return isExecuting;
    }
    
    //creates the commands for adding a command in autonomous
    public void addCommand(MainCommand command) {
        commands.add(command);
    }

    public void clearCommands() {
        count=0;
        //this.commands.removeAll(commands);
    }
}
