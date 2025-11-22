// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  public final TalonFX right = new TalonFX(1);
  public final TalonFX left = new TalonFX(2);
  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double yaxis, double xaxis){
    double rightValue = yaxis + xaxis;
    double leftValue = yaxis - xaxis;

    right.set(rightValue);
    left.set(leftValue);
  }
}
