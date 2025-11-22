// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterDrivetrain extends SubsystemBase {
  /** Creates a new LauncherDrivetrain. */
  private DigitalInput m_sensor = new DigitalInput(0);
  private TalonFX m_leftMotor = new TalonFX(1);
  private TalonFX m_rightMotor = new TalonFX(2);

  public ShooterDrivetrain() {}

  private boolean checkForBall() {
    return m_sensor.get();
  }

  private void launchBall() {
    Timer timer = new Timer();
    timer.start();

    if (checkForBall()) {
      while (timer.get() < 5) {
        m_leftMotor.set(0.5);
        m_rightMotor.set(-0.5);
      }
      timer.stop();
      timer.reset();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
