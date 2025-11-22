// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  /** Creates a new Launcher. */
  public TalonFX rightWheel = new TalonFX(3);
  public TalonFX leftWheel = new TalonFX(4);
  public AddressableLED led = new AddressableLED(10);
  public AddressableLEDBuffer buffer = new AddressableLEDBuffer(10);
  public DigitalInput in = new DigitalInput(10);

  public Launcher() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startMotor(){
    boolean running = in.get();
    
    if (running){
      rightWheel.set(10.0);
      leftWheel.set(10.0);
      buffer.setRGB(19, 240,100,80);
      led.setData(buffer);
    }
    else if (!running){
      rightWheel.set(0.0);
      leftWheel.set(0.0);
      buffer.setRGB(19, 0,150,85);
      led.setData(buffer);
    }

  }
}
