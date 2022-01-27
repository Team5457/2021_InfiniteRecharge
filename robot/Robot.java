// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.nexuscommand.*;
import edu.wpi.first.wpilibj.Timer;
/*import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonImuJNI;
import com.ctre.phoenix.sensors.PigeonIMU.FusionStatus;
import com.ctre.phoenix.sensors.PigeonIMU.GeneralStatus;
//import com.ctre.phoenix.sensors.PigeonIMU.PigeonState;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.SolenoidBase.*;
*/
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;



public class Robot extends TimedRobot {
  public double fangle;
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private SensorManager sensors = new SensorManager();
  public final Driver driveSystem = new Driver();
  //private final CameraManager cameraSystem = new CameraManager();

  //private Shoot shootSystem = new Shoot();


  private final Joystick sJoy = new Joystick(0);
  private final Joystick xCon = new Joystick(1);
  //public static AutoManager auto = new AutoManager();
  private UsbCamera camera;
  public final static AnalogInput ultrasonic = new AnalogInput(0);
  public static double rawValue;
  private static int count = 0;
  private boolean babymode = false;
  private final Timer timer = new Timer();
  private VictorSP colorwheel = new VictorSP(3);
  //pneumatics
  //Compressor compressor = new Compressor(0);
  //static DoubleSolenoid snoid = new DoubleSolenoid(0,1);
  
  

  //pickup system
  //private final pickupSystem pickUp = new pickupSystem();
  Joystick controller;



  



  //public static PigeonIMU pidgey = new PigeonIMU(0);
  public static double currentAngle;
  public static Boolean angleIsGood;
  public static final int kTimeoutMs = 30;

  //public static GeneralStatus stat2= new GeneralStatus();
 
  //public static FusionStatus stat = new FusionStatus();
 

  //public static AHRS ahrs = new AHRS(SPI.Port.kMXP);
  PIDController turnController;

  //private double isplacementz = (double)ahrs.getDisplacementZ();
 


  //constant error value
  static final double kP = 1;
  static final double kI = 0.00;
  static final double kD = 0.00;
  static final double kF = 0.00;
  
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    turnController = new PIDController(kP, kI, kD);
    turnController.enableContinuousInput(-180.0f, 180.0f);
    controller = new Joystick(0);
    /*
    ahrs.zeroYaw();
    ahrs.zeroYaw();

    pidgey.configFactoryDefault();
    compressor.setClosedLoopControl(false);

    // Displays things on Shuffleboard
    Shuffleboard.getTab("Navx Compass").add((Sendable) ahrs);
    */

  


  }


  @Override
  public void robotPeriodic() {


    
  }


  @Override
  public void autonomousInit() {
    // add commands to the array

    
    //pidgey.setFusedHeading(0.0, kTimeoutMs);
    /*
    auto.clearCommands();

    //motors are backwards - left is right!!!
    auto.addCommand(new drive(-0.5,-0.55,2,driveSystem));
    auto.addCommand(new Wait(1, driveSystem));
    auto.addCommand(new autoShoot(.7, shootSystem));
    auto.addCommand(new Wait(2, driveSystem));
    auto.addCommand(new drive(0.5,0.5,.5,driveSystem));
    */
   
    //auto.addCommand(new Search(driveSystem, pickupSystem));
    





    

    
    
   
    
  }
  
  
  

 
  @Override

  public void autonomousPeriodic() 
  {
    //PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
    //PigeonIMU.FusionStatus stat = new PigeonIMU.FusionStatus();
    //pidgey.getFusedHeading(stat);
    //currentAngle = stat.heading;
    //angleIsGood = (pidgey.getState() == PigeonState.Ready);
    rawValue = ultrasonic.getValue()*0.128;

    
      //runs the array
      /*
      if (!auto.driveExecuting)
        driveSystem.stopRobot();
      auto.execute();
      */

      

       
      
      
        
      }
  

  
  @Override
  public void teleopInit() {
    //compressor.setClosedLoopControl(true);
    //snoid.set(Value.kReverse);
  }

  @Override
 
  public void teleopPeriodic() {
    //PigeonIMU.FusionStatus stat = new PigeonIMU.FusionStatus();
    //reads the controller input
    driveSystem.driveRobot(xCon);
    
    //pickupSystem.spinMotor(xCon);
    //shootSystem.shoot(xCon);
    //System.out.println(psi);
    //pneumaticSystem.pneumatic(xCon);

    //displays the value of displacement
    rawValue = ultrasonic.getValue()*0.128;
    if (babymode){
      if(rawValue<200){
        driveSystem.driveMotorSpeeds(-0.8, -0.8);
      }
    }
      

    /*pickup motor
    
      pickUp.pickup(xCon);
    
     //put down
    
      pickUp.pickupVerticalDown(xCon);
  
     //lift up
 
      pickUp.pickupVerticalUp(xCon);
    */
    //Pnumatics
    /*compressor.setClosedLoopControl(false);
    if(sJoy.getRawAxis(3) == 1){
      compressor.setClosedLoopControl(false);
    }
    else if(sJoy.getRawAxis(3) == 0){
      compressor.setClosedLoopControl(true);
    }


    
    if(sJoy.getRawButton(5)){

      snoid.set(Value.kForward);

    }
    else if(sJoy.getRawButton(3)){

      snoid.set(Value.kReverse);
    }
    */
    //colorwheel scavenged from the old picker
    if(sJoy.getRawButton(1)){
      colorwheel.set(1);
    }
    else{
      colorwheel.set(0);
    }
    
    
  
  

    /*
   SmartDashboard.putNumber("Angle", ahrs.getAngle());
   SmartDashboard.putNumber("Displacement X", ahrs.getDisplacementX());
   SmartDashboard.putNumber("Displacement Z", ahrs.getDisplacementZ());
   SmartDashboard.putNumber("Displacement Y", ahrs.getDisplacementY());
    */

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {

   

  }



  @Override
  public void testPeriodic() {
/*

    if (!auto.driveExecuting)
    driveSystem.stopRobot();
  auto.execute();
*/



  }





}
