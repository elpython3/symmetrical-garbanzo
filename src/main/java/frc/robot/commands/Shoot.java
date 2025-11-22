// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Shoot extends Command {
  /** Creates a new Shoot. */
  private Shooter shooter = new Shooter();
  private double start_time;
  private boolean first_time = false;

  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (shooter.getfiring()){
      if (first_time = false){
        start_time = Timer.getFPGATimestamp();
      }
      shooter.setwheels();
      shooter.ledwhite();
    }

    if (Timer.getFPGATimestamp() - start_time > 5){
      first_time = true;
      shooter.setfiring(false);
      shooter.stopwheels();
      shooter.ledblue();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished(){
    return false;
  }
}
