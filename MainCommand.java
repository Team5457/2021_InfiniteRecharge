//All other commands are under this, which defines isCompleted and isDone, where all other commands use them

//Yeah what that guy said, dont mess with this its important and you arent smart enough to figure it out

public abstract class MainCommand {
    private boolean completed;


    public MainCommand(){
        this.completed=false;
    }

    public boolean isCompleted()
    {
        return completed;
    }
    
    public void isDone()
    {
        this.completed=true;
    }
    public abstract void whileExecuting();
    public abstract void completed();
}
