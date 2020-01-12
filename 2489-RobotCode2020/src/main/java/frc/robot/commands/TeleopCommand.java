/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drivetrain;

public class TeleopCommand extends Command {
  public TeleopCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.subsystem);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double kLVoltage = 12 /Robot.drivetrain.leftFrontMaster.getBusVoltage();
    //double kRVoltage = 12/Robot.drivetrain.rightFrontMaster.getBusVoltage();
   
    //Robot.drivetrain.rightFrontMaster.set(ControlMode.PercentOutput,-Robot.oi.rightstick.getY() * kRVoltage);
    //Robot.drivetrain.leftFrontMaster.set(ControlMode.PercentOutput,Robot.oi.leftstick.getY() * kLVoltage);
    double move = -0.5*Robot.oi.rightstick.getY()+Robot.oi.leftstick.getY();
    double turn = -0.5*Robot.oi.rightstick.getX()+Robot.oi.leftstick.getX();
    drivetrain.teleopmanualdrive(move,turn);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
