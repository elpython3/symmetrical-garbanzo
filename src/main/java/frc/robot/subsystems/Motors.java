// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Motors extends SubsystemBase {
  private final TalonFX rightMotor = new TalonFX(0);
  private final TalonFX leftMotor = new TalonFX(1);

  /** Creates a new Motors. */
  public Motors() {
    leftMotor.setInverted(true);
  }

  public void setSpeed(double speed, double turn) {
    rightMotor.set((speed - turn) * 0.5);
    leftMotor.set((speed + turn) * 0.5);
  }

  @Override
  public void periodic() {
    setSpeed(RobotContainer.getSpeed(), RobotContainer.getTurn());
  }
}
