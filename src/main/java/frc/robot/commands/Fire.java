// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Fire extends Command {
  private Shooter gas = new Shooter();
  private Timer timer = new Timer();
  private boolean toRun; 
  private double time1;// or not to run
  /** Creates a new Fire. */
  public Fire(Shooter shooter) {
    gas = shooter;
    addRequirements(gas);// Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    toRun = gas.getRun();
    if(toRun){
      time1 = timer.getFPGATimestamp();
      gas.shoot(-1.0,1.0);
      gas.flash(true);
      toRun = false;
    }
    if(timer.getFPGATimestamp()-time1 == 5){
      gas.flash(false);
      gas.shoot(0,0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
