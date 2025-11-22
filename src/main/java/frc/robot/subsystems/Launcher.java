// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  private final AddressableLED leds = new AddressableLED(80);
  private final AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(60);

  private final TalonFX motor1 = new TalonFX(3);
  private final TalonFX motor2 = new TalonFX(4);
  
  private final DigitalInput sensor = new DigitalInput(0);

  private double activatedTime;
  private final double ACTIVE_TIME = 5;

  /** Creates a new Launcher. */
  public Launcher() {
    leds.setData(ledBuffer);
    motor2.setInverted(true);

    activatedTime = -1;
  }

  public void launch() {
    setSpeed(0.25);
    setColor(255, 0, 0);
    activatedTime = Timer.getTimestamp();
  }

  public void deactivate() {
    setSpeed(0);
    setColor(0, 255, 0);
    activatedTime = -1;
  }

  private void setSpeed(double speed) {
    motor1.set(speed);
    motor2.set(speed);
  }

  public void setColor(int r, int g, int b) {
    for (int i = 0; i < ledBuffer.getLength(); i++) {
      ledBuffer.setRGB(i, r, g, b);
    }
  }

  @Override
  public void periodic() {
    if (sensor.get()) {
        launch();
    } else if (activatedTime < Timer.getTimestamp() - ACTIVE_TIME) {
      deactivate();
    }
  }
}
