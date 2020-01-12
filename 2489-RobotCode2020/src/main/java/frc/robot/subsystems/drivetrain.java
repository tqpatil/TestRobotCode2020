/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//Spark imports 
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Spark
  //public Spark leftFrontMotor= new Spark(1);
  //public Spark rightFrontMotor= new Spark(2);
  //public Spark rightBackMotor= new Spark(3);
  //public Spark leftBackMotor= new Spark(4);
  //SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
  //SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);

  //public DifferentialDrive drive= new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  public static WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public static WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);

  // Differential Drive
  public static DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  // construcctor
  public drivetrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  public static void teleopmanualdrive(double move, double turn) {

    //MaxSpeed
    if (Math.abs (move)>0.5)
      move= 0.5;
    else move=move;

    //Deadband
    if (Math.abs (move)<0.10)
      move=0;
    if (Math.abs (turn)<0.10)
      turn=0;
    
    drive.tankDrive(move, turn);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
