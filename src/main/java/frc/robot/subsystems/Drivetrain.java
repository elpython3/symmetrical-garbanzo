// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix6.controls.StrictFollower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final TalonFX leftFront = new TalonFX(Constants.DrivetrainConstants.frontLeftMotorID);
  private final TalonFX leftBack = new TalonFX(Constants.DrivetrainConstants.backLeftMotorID);
  private final TalonFX rightFront = new TalonFX(Constants.DrivetrainConstants.frontRightMotorID);
  private final TalonFX rightBack = new TalonFX(Constants.DrivetrainConstants.backRightMotorID);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftBack.setControl(new StrictFollower(Constants.DrivetrainConstants.frontLeftMotorID));
    rightBack.setControl(new StrictFollower(Constants.DrivetrainConstants.frontRightMotorID));
  }

  public void drive(double speed, double turn){
    double left = (speed + turn) * 0.5;
    double right = (speed - turn) * 0.5;

    leftFront.set(left);
    rightFront.set(-right);
  }

  public void stop(){
    drive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
