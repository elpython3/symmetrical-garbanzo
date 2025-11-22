package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    XboxController joystick = new XboxController(0);

    public TalonFX left = new TalonFX(0);
    public TalonFX right = new TalonFX(1);



    public void setSpeed(double ya, double xa) {
        double lv = ya + xa;
        double rv = ya - xa;
    
        left.set(lv);
        right.set(rv);
      }

    public 
    
    @Override
    public void periodic(){

    }
}
