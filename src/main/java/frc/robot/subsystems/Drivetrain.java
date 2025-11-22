// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  private XboxController controller = new XboxController(0);
  private TalonFX lMotor = new TalonFX(132);
  private TalonFX rMotor = new TalonFX(133);
  private double speed;
  private double turn;

  public Drivetrain() {

  }

  @Override
  public void periodic() {
    
  }

  public void speed(int speed, int turn) {
      this.speed = speed;
      this.turn = turn;
  }
}
