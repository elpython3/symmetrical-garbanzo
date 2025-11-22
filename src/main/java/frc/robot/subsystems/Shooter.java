// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private TalonFX leftwheel = new TalonFX(1);
  private TalonFX rightwheel = new TalonFX(2);
  private AddressableLED led = new AddressableLED(1);
  private AddressableLEDBuffer buffer = new AddressableLEDBuffer(60);
  private DigitalInput sensor = new DigitalInput(1);
  private boolean is_firing = false;
  /** Creates a new Shooter. */
  public Shooter() {
    led.setLength(buffer.getLength());
  
  }

  @Override
  public void periodic() {
    is_firing = sensor.get();
    // This method will be called once per scheduler run
  }

  public void setwheels(){
    leftwheel.set(0.35);
    rightwheel.set(0.35);
  }

  public void stopwheels(){
    leftwheel.set(0);
    rightwheel.set(0);
  }
  public void ledwhite(){
    int length = buffer.getLength();
    int index = 0;
    for (index = 0; index < length; index++){
      buffer.setRGB(index, 255, 255, 255);
    }
  }

  public void ledblue(){
    int length = buffer.getLength();
    int index = 0;
    for (index = 0; index < length; index++){
      buffer.setRGB(index, 10, 10, 255);
    }
  }

  public void setfiring(boolean b){
    is_firing = b;
  }

  public boolean getfiring(){
    return is_firing;
  }
}
