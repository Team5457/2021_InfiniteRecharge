package frc.robot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;



public class pickupSystem {

    private VictorSP pickup;
    private VictorSP pickupVertical;


    public pickupSystem(){

        pickup = new VictorSP(3);
        pickupVertical = new VictorSP(4);
    }

    public void pickup(Joystick controller){
        if(controller.getRawButton(10)){
            pickup.setSpeed(0.9);
            //speed pickup
        }
        else{
            pickupStop();
        }
          

    }

    public void pickupVerticalUp(Joystick controller){

        //put up
        if(controller.getRawButton(5)){
            pickupVertical.setSpeed(0.4);
            //speed vertical up
        }
        verticalStop();
    }

    public void pickupVerticalDown(Joystick controller){

        //put down
        if(controller.getRawButton(9)){
            pickupVertical.setSpeed(-0.6);
            //speed vertical down
        }
        else{
            verticalStop();
        }
    }

    public void pickupStop(){
        pickup.set(0);

    }

    public void verticalStop(){
        pickupVertical.set(0);
    }


    

    
}
