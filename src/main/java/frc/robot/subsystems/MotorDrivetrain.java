// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class MotorDrivetrain extends SubsystemBase {
  /** Creates a new MotorDrivetrain. */
  private TalonFX m_leftMotor = new TalonFX(0);
  private TalonFX m_rightMotor = new TalonFX(1);

  public MotorDrivetrain() {
  }

  public void startDriving(double speed, double turn) {
    double leftSpeed = speed + turn;
    double rightSpeed = speed - turn;

    m_leftMotor.set(leftSpeed);
    m_rightMotor.set(-rightSpeed);
  }

  public void stopMotors() {
    m_leftMotor.set(0);
    m_rightMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
