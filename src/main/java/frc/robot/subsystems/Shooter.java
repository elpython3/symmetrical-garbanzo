// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class Shooter extends SubsystemBase {
    private TalonFX motorLeft = new TalonFX(0);
    private TalonFX motorRight = new TalonFX(0);
    private DigitalInput sensor = new DigitalInput(0);
    private AddressableLEDBuffer led = new AddressableLEDBuffer(67);
    private static boolean detected = false;
    private static int secCounter = 0;
  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    motorRight.setInverted(true);
    setSpeed(0);
  }

  public void setSpeed(double speed){
    motorLeft.set(speed);
    motorRight.set(speed);
  }

  public boolean objectDetected(){
    return sensor.get();
  }
  @Override
  public void periodic() {
    secCounter += 20;
    if(objectDetected() && !detected){
        detected = true;
        setSpeed(.45);
        secCounter = 0;
        for(int i = 0; i < led.getLength(); i++){
            led.setRGB(i, 255, 0, 0);
        }
    }
    if(secCounter >= 5000){
        setSpeed(0);
        detected = false;
        for(int i = 0; i < led.getLength(); i++){
            led.setRGB(i, 0, 255, 0);
        }
    }
  }

}
