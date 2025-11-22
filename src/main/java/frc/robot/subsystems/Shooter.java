// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(120);
  private TalonFX left = new TalonFX(2);
  private TalonFX right = new TalonFX(3);
  private DigitalInput in = new DigitalInput(4);
  private DigitalInput out = new DigitalInput(5);
  private boolean run = false;
  public Shooter() {}

  @Override
  public void periodic() {
    run = (in.get() || out.get());
    // This method will be called once per scheduler run
  }
  public void shoot(double leftSpe,double rightSpe){
    left.set(leftSpe);
    right.set(rightSpe);
  }
  public DigitalInput getIn(){
    return in;
  }
  public DigitalInput getOut(){ // peakest method name
    return out;
  }
  public boolean getRun(){
    return run;
  }
  public void flash(boolean whiteOrBlack){
    if(whiteOrBlack){
      for(int count =1;count<ledBuffer.getLength();count++){
        ledBuffer.setRGB(count, 255, 255, 255);
      }
    }
    else{
      for(int count =1;count<ledBuffer.getLength();count++){
        ledBuffer.setRGB(count, 0, 0, 0);
      }
    }
}
}
