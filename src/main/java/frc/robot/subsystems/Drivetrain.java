// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  TalonFX right = new TalonFX(0);
  TalonFX left = new TalonFX(1);
  /** Creates a new Drivetrain. */
  public Drivetrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double speed, double turn){
    left.set(speed+turn);
    right.set(speed-turn);
  }
}
